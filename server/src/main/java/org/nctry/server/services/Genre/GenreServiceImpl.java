package org.nctry.server.services.Genre;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Override
    public void saveGenre(String genreDTO) {
        /*
            TODO:
                Crear o actualizar cancion
                Manejo de error 403
        */
    }

    @Override
    public void deleteGenre(Long genreDTO) {
        /*
            TODO:
                Eliminar genero
                Manejo de error 404
        */
    }

    @Override
    public List<String> getAllGenres() {
        return List.of();
        /*
            TODO:
                Obtener todos los generos
        */
    }

    @Override
    public void assignGenreToSong(Long genreId, Long songId) {
        /*
            TODO:
                Asigna un genero a una cancion
        */
    }

    @Override
    public void unassignGenreFromSong(Long genreId, Long songId) {
        /*
            TODO:
                Quita la asignacion del genero
        */
    }

    @Override
    public void assignGenreToPlaylist(Long genreId, Long playlistId) {
        /*
            TODO:
                Asigna un genero a una playlist
        */
    }

    @Override
    public void unassignGenreFromPlaylist(Long genreId, Long playlistId) {
        /*
            TODO:
                Quita la asignacion un genero a una playlist
        */
    }

    @Override
    public void assignGenreToArtist(Long genreId, Long artistId) {
        /*
            TODO:
                Asigna un genero a un artista
        */
    }

    @Override
    public void unassignGenreFromArtist(Long genreId, Long artistId) {
        /*
            TODO:
                Quita la asignacion un genero a un artista
        */
    }
}
