package org.nctry.server.services.Genre;

import org.nctry.server.Utilities.Pages.SortUtils;
import org.nctry.server.Utilities.Pages.mappers.ResponseMapper;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.song.dto.maps.GenreMapper;
import org.nctry.server.song.dto.maps.SongMapper;
import org.nctry.server.song.dto.response.dtoGenre;
import org.nctry.server.song.dto.response.dtoPlaylist;
import org.nctry.server.song.dto.response.dtoSong;
import org.nctry.server.song.model.Genre;
import org.nctry.server.song.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private final IGenreRepository genreRepository;


    //Mappers
    private SongMapper songMapper;
    private GenreMapper genreMapper;

    @Autowired
    public GenreServiceImpl(IGenreRepository genreRepository) {
        this.genreRepository = genreRepository;
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
        genreMapper = GenreMapper.INSTANCE;
        ResponseMapper responseMapper = ResponseMapper.INSTANCE;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir));

        Page<Genre> users = genreRepository.findAll(pageable);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("Users", "page", pageNumber.toString());
        }
        return  responseMapper.mapToResponse(
                users.getContent().stream().map(genreMapper::genreToDtoGenre).toList(),
                pageNumber,
                pageSize,
                users.getTotalElements(),
                users.isLast()
        );
    }

    /*@Override
    @Cacheable("")
    public dtoSong getSongsByGenre(dtoGenre dtoGenre) {
        return null;
    }*/

    @Override
    @Cacheable("assignedToSong")
    public dtoSong assignGenreToSong(Long genreId, Long songId) {
        /*
            TODO:
                Asigna un genero a una cancion
        */
        return null;
    }

    @Override
    @Cacheable("unassignedToSong")
    public dtoSong unassignGenreFromSong(Long genreId, Long songId) {
        /*
            TODO:
                Quita la asignacion del genero
        */
        return null;
    }

    @Override
    @Cacheable("assignedToPlaylist")
    public dtoPlaylist assignGenreToPlaylist(Long genreId, Long playlistId) {
        /*
            TODO:
                Asigna un genero a una playlist
        */
        return null;
    }

    @Override
    @Cacheable("unassignedToPlaylist")
    public dtoPlaylist unassignGenreFromPlaylist(Long genreId, Long playlistId) {
        /*
            TODO:
                Quita la asignacion un genero a una playlist
        */
        return null;
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
