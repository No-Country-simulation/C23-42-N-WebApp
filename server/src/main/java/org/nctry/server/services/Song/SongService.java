package org.nctry.server.services.Song;

import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.response.DtoSong;
import org.springframework.cache.annotation.Cacheable;

public interface SongService {
    //@Cacheable("all-songs")
    GeneralResponse getAllActiveSongs(
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir);

    //@Cacheable("all-songs-byName")
    GeneralResponse getAllActiveSongsByName(
            String name,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir);

    //@Cacheable("all-songs-byArtist")
    GeneralResponse getAllActiveSongsByArtist(
            String artistName,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir);


    /*DtoSong getSongById(Long id);

    DtoSong saveSong(DtoSong dtoNewSong);

    void deleteSongByNameAndArtist(DtoSong dtoSong);

    void deleteSongById(Long id);

    void wipeSongById(Long id);

    void wipeSongByNameAndArtist(DtoSong dtoSong);

    void likeSong(Long userId, Long songId);*/
}
