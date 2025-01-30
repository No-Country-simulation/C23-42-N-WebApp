package org.nctry.server.services.Genre;

import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.response.dtoGenre;
import org.nctry.server.song.dto.response.dtoPlaylist;
import org.nctry.server.song.dto.response.dtoSong;

public interface GenreService {
    dtoGenre saveGenre(dtoGenre genreDTO);
    //void deleteGenre(Long genreDTO);
    GeneralResponse getAllGenres(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    //dtoSong getSongsByGenre(dtoGenre dtoGenre);
    dtoSong assignGenreToSong(Long genreId, Long songId);
    dtoSong unassignGenreFromSong(Long genreId, Long songId);
    dtoPlaylist assignGenreToPlaylist(Long genreId, Long playlistId);
    dtoPlaylist unassignGenreFromPlaylist(Long genreId, Long playlistId);

    //void assignGenreToArtist(Long genreId, Long artistId);
    //void unassignGenreFromArtist(Long genreId, Long artistId);
}
