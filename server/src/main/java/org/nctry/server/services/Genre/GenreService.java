package org.nctry.server.services.Genre;

import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.response.DtoGenre;
import org.nctry.server.song.dto.response.DtoSong;
import org.nctry.server.song.dto.response.dtoPlaylist;

public interface GenreService {
    //DtoGenre saveGenre(DtoGenre genreDTO);
    //void deleteGenre(Long genreDTO);
    GeneralResponse getAllGenres(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    GeneralResponse getSongsByGenre(String name, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    /*DtoSong assignGenreToSong(Long genreId, Long songId);
    DtoSong unassignGenreFromSong(Long genreId, Long songId);
    dtoPlaylist assignGenreToPlaylist(Long genreId, Long playlistId);
    dtoPlaylist unassignGenreFromPlaylist(Long genreId, Long playlistId);*/

    //void assignGenreToArtist(Long genreId, Long artistId);
    //void unassignGenreFromArtist(Long genreId, Long artistId);
}
