package org.nctry.server.services.Genre;

import org.nctry.server.Utilities.Pages.SortUtils;
import org.nctry.server.Utilities.Pages.mappers.ResponseMapper;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.song.dto.maps.GenreMapper;
import org.nctry.server.song.dto.maps.PlaylistMapper;
import org.nctry.server.song.dto.maps.SongMapper;
import org.nctry.server.song.dto.response.dtoGenre;
import org.nctry.server.song.dto.response.dtoPlaylist;
import org.nctry.server.song.dto.response.dtoSong;
import org.nctry.server.song.model.Genre;
import org.nctry.server.song.model.Playlist;
import org.nctry.server.song.model.Song;
import org.nctry.server.song.repository.IGenreRepository;
import org.nctry.server.song.repository.IPlaylistRepository;
import org.nctry.server.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private final IGenreRepository genreRepository;
    private final ISongRepository songRepository;
    private final IPlaylistRepository playlistRepository;


    //Mappers
    private SongMapper songMapper;
    private GenreMapper genreMapper;
    private ResponseMapper responseMapper;
    private PlaylistMapper playlistMapper;

    @Autowired
    public GenreServiceImpl(IGenreRepository genreRepository, ISongRepository songRepository, IPlaylistRepository playlistRepository) {
        this.genreRepository = genreRepository;
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
    }

    @Override
    public dtoGenre saveGenre(dtoGenre genreDTO) {
        genreMapper = GenreMapper.INSTANCE;
        Genre genre = genreMapper.dtoGenreToGenre(genreDTO);
        genreRepository.save(genre);
        return genreMapper.genreToDtoGenre(genre);
    }

   /* @Override
    public void deleteGenre(Long genreDTO) {
        *//*
            TODO:
                Eliminar genero
                Manejo de error 404
        *//*
    }*/

    @Override
    @Cacheable("all-genres")
    public GeneralResponse getAllGenres(
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir
    ) {
        responseMapper = ResponseMapper.INSTANCE;
        genreMapper = GenreMapper.INSTANCE;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "Genre"));

        Page<Genre> genres = genreRepository.findAll(pageable);
        if (genres.isEmpty()) {
            throw new ResourceNotFoundException("Genre", "page", pageNumber.toString());
        }
        return  responseMapper.mapToResponse(
                genres.getContent().stream().map(genre -> genreMapper.genreToDtoGenre(genre)).toList(),
                pageNumber,
                pageSize,
                genres.getTotalElements(),
                genres.isLast()
        );
    }

    @Override
    @Cacheable("SongsByGenre")
    public GeneralResponse getSongsByGenre(
            Long genreId,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir
    ) {
        responseMapper = ResponseMapper.INSTANCE;
        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", genreId.toString()));
        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "Song"));
        Page<Song> songs = songRepository.findAllByGenresContains(genre, pageable);
        if (songs.isEmpty()) {
            throw new ResourceNotFoundException("Song", "page", pageNumber.toString());
        }

        return responseMapper.mapToResponse(
                responseMapper.toObjectList(songs.getContent().stream().map(song -> songMapper.songToDtoSong(song)).toList()),
                pageNumber,
                pageSize,
                songs.getTotalElements(),
                songs.isLast()
        );
    }

    @Override
    @Cacheable("assignedToSong")
    public dtoSong assignGenreToSong(Long genreId, Long songId) {
        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", genreId.toString()));
        Song song = songRepository.findById(songId).orElseThrow(() -> new ResourceNotFoundException("Song", "id", songId.toString()));
        song.getGenres().add(genre);
        songRepository.save(song);

        return songMapper.songToDtoSong(song);
    }

    @Override
    @Cacheable("unassignedToSong")
    public dtoSong unassignGenreFromSong(Long genreId, Long songId) {
        songMapper = SongMapper.INSTANCE;

        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", genreId.toString()));
        Song song = songRepository.findById(songId).orElseThrow(() -> new ResourceNotFoundException("Song", "id", songId.toString()));
        song.getGenres().remove(genre);
        songRepository.save(song);

        return songMapper.songToDtoSong(song);
    }

    @Override
    @Cacheable("assignedToPlaylist")
    public dtoPlaylist assignGenreToPlaylist(Long genreId, Long playlistId) {
        playlistMapper = PlaylistMapper.INSTANCE;

        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", genreId.toString()));
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new ResourceNotFoundException("Playlist", "id", playlistId.toString()));

        playlist.getGenres().add(genre);
        playlistRepository.save(playlist);

        return playlistMapper.playlistToDtoPlaylist(playlist);
    }

    @Override
    @Cacheable("unassignedToPlaylist")
    public dtoPlaylist unassignGenreFromPlaylist(Long genreId, Long playlistId) {
        playlistMapper = PlaylistMapper.INSTANCE;

        Genre genre = genreRepository.findById(genreId).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", genreId.toString()));
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new ResourceNotFoundException("Playlist", "id", playlistId.toString()));

        playlist.getGenres().remove(genre);
        playlistRepository.save(playlist);

        return playlistMapper.playlistToDtoPlaylist(playlist);
    }

    /*@Override
    public void assignGenreToArtist(Long genreId, Long artistId) {
        *//*
            TODO:
                Asigna un genero a un artista
        *//*
    }

    @Override
    public void unassignGenreFromArtist(Long genreId, Long artistId) {
        *//*
            TODO:
                Quita la asignacion un genero a un artista
        *//*
    }*/
}
