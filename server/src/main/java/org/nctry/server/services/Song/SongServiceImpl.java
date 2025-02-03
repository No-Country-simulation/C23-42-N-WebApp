package org.nctry.server.services.Song;

import jakarta.transaction.Transactional;
import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.Utilities.Pages.SortUtils;
import org.nctry.server.Utilities.Pages.mappers.PaginationMapper;
import org.nctry.server.Utilities.Pages.mappers.ResponseMapper;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.maps.GenreMapper;
import org.nctry.server.song.dto.maps.PlaylistMapper;
import org.nctry.server.song.dto.maps.SongMapper;
import org.nctry.server.song.dto.response.dtoSong;
import org.nctry.server.song.model.Song;
import org.nctry.server.song.repository.IArtistRepository;
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
public class SongServiceImpl implements SongService {

    private final IGenreRepository genreRepository;
    private final ISongRepository songRepository;
    private final IArtistRepository artistRepository;
    private final IPlaylistRepository playlistRepository;

    //Mappers
    private final ResponseMapper responseMapper ;
    private final PaginationMapper paginationMapper;
    private final SongMapper songMapper;
    private final GenreMapper genreMapper;
    private final PlaylistMapper playlistMapper;

    @Autowired
    public SongServiceImpl(
            IGenreRepository genreRepository,
            ISongRepository songRepository,
            IArtistRepository artistRepository,
            IPlaylistRepository playlistRepository,
            ResponseMapper responseMapper,
            PaginationMapper paginationMapper,
            SongMapper songMapper,
            GenreMapper genreMapper,
            PlaylistMapper playlistMapper
            )
    {
        this.genreRepository = genreRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.playlistRepository = playlistRepository;
        this.responseMapper = ResponseMapper.INSTANCE;
        this.paginationMapper = PaginationMapper.INSTANCE;
        this.songMapper = SongMapper.INSTANCE;
        this.genreMapper = GenreMapper.INSTANCE;
        this.playlistMapper = PlaylistMapper.INSTANCE;
    }

    @Override
    @Cacheable("all-songs")
    public GeneralResponse getAllActiveSongs(
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir)
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "Genre"));

        Page<Song> songs = songRepository.findAllByIsActiveTrueAndIsPublicTrue(pageable);

        if (songs.isEmpty()) {
            throw new ResourceNotFoundException("Song", "page", pageNumber.toString());
        }

        return  responseMapper.mapToResponse(
                songs.getContent().stream().map(songMapper::songToDtoSong).toList(),
                paginationMapper.mapToResponse(
                        pageNumber,
                        pageSize,
                        songs.getTotalElements(),
                        songs.isLast()
                )
        );
    }

    @Override
    @Cacheable("all-songs-byName")
    public GeneralResponse getAllActiveSongsByName(
            String name,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir)
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "Song"));

        Page<Song> songs = songRepository.findByNameContainingIgnoreCaseAndIsActiveTrueAndIsPublicTrue(name, pageable);

        if (songs.isEmpty()) {
            throw new ResourceNotFoundException("Song", "page", pageNumber.toString());
        }

        return responseMapper.mapToResponse(
                songs.getContent().stream().map(songMapper::songToDtoSong).toList(),
                paginationMapper.mapToResponse(
                        pageNumber,
                        pageSize,
                        songs.getTotalElements(),
                        songs.isLast()
                )
        );
    }

    @Override
    @Cacheable("all-songs-byArtist")
    public GeneralResponse getAllActiveSongsByArtist(
            String artistName,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir)
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "Song"));

        Page<Song> songs = songRepository.findByArtists_NameContainingIgnoreCaseAndIsPublicTrue(artistName, pageable);

        if (songs.isEmpty()) {
            throw new ResourceNotFoundException("Song", "page", pageNumber.toString());
        }

        return responseMapper.mapToResponse(
                songs.getContent().stream().map(songMapper::songToDtoSong).toList(),
                paginationMapper.mapToResponse(
                        pageNumber,
                        pageSize,
                        songs.getTotalElements(),
                        songs.isLast()
                )
        );
    }

    @Override
    @Cacheable("all-songs-byGenre")
    public GeneralResponse getAllActiveSongsByGenre(
            String genreName,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir)
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "Song"));

        Page<Song> songs = songRepository.findByGenres_NameContainingIgnoreCaseAndIsPublicTrue(genreName, pageable);

        if (songs.isEmpty()) {
            throw new ResourceNotFoundException("Song", "page", pageNumber.toString());
        }

        return responseMapper.mapToResponse(
                songs.getContent().stream().map(songMapper::songToDtoSong).toList(),
                paginationMapper.mapToResponse(
                        pageNumber,
                        pageSize,
                        songs.getTotalElements(),
                        songs.isLast()
                )
        );
    }

    @Override
    public dtoSong getSongById(Long id)
    {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song", "id", id.toString()));

        return songMapper.songToDtoSong(song);
    }



    @Override
    public dtoSong saveSong(dtoSong dtoNewSong) {
        Song newSong = songMapper.dtoSongToSong(dtoNewSong);
        Song savedSong = songRepository.save(newSong);

        return songMapper.songToDtoSong(savedSong);
    }

    @Override
    @Transactional
    public void deleteSongByNameAndArtist(dtoSong dtoSong) {

        Song song = songRepository.findByNameAndArtists(dtoSong.getName(), dtoSong.getArtists())
                .orElseThrow(() -> new ResourceNotFoundException("Song", "name & artists", dtoSong.getName() + " - " + dtoSong.getArtists()));

        song.setActive(false);

        songRepository.save(song);
    }

    @Override
    @Transactional
    public void deleteSongById(Long id) {

        Song song = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song", "id", id.toString()));

        song.setActive(false);

        songRepository.save(song);
    }

    @Override
    @Transactional
    public void wipeSongById(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song", "id", id.toString()));

        songRepository.delete(song);
    }

    @Override
    @Transactional
    public void wipeSongByNameAndArtist(dtoSong dtoSong){

        Song song = songRepository.findByNameAndArtists(dtoSong.getName(), dtoSong.getArtists())
                .orElseThrow(() -> new ResourceNotFoundException("Song", "name & artist", dtoSong.getName() + " - " + dtoSong.getArtists()));

        songRepository.delete(song);
    }

    @Override
    @Transactional
    public void likeSong(Long userId, Long songId) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song", "id", songId.toString()));

        if (song.getLikedByUsers().contains(userId)) {
            throw new IllegalStateException("¡Ya te gusta esta canción!");
        }

        song.getLikedByUsers().add(userId);
        song.setLikes(song.getLikes() + 1);

        songRepository.save(song);
    }
}
