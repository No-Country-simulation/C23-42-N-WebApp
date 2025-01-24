package org.nctry.server.services.Genre;

import java.util.List;

public interface GenreService {
    void saveGenre(String genreDTO);
    void deleteGenre(Long genreDTO);
    List<String> getAllGenres();
    void assignGenreToSong(Long genreId, Long songId);
    void unassignGenreFromSong(Long genreId, Long songId);
    void assignGenreToPlaylist(Long genreId, Long playlistId);
    void unassignGenreFromPlaylist(Long genreId, Long playlistId);
    void assignGenreToArtist(Long genreId, Long artistId);
    void unassignGenreFromArtist(Long genreId, Long artistId);
}
