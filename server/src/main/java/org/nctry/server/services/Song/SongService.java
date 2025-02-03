package org.nctry.server.services.Song;

import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.response.dtoSong;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface SongService {

    @Cacheable("all-songs")
    GeneralResponse getAllActiveSongs(
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir);

    @Cacheable("all-songs-byName")
    GeneralResponse getAllActiveSongsByName(
            String name,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir);

    @Cacheable("all-songs-byArtist")
    GeneralResponse getAllActiveSongsByArtist(
            String artistName,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir);

    @Cacheable("all-songs-byGenre")
    GeneralResponse getAllActiveSongsByGenre(
            String genreName,
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir);

    dtoSong getSongById(Long id);

    dtoSong saveSong(dtoSong dtoNewSong);

    void deleteSongByNameAndArtist(dtoSong dtoSong);

    void deleteSongById(Long id);

    void wipeSongById(Long id);

    void wipeSongByNameAndArtist(dtoSong dtoSong);

    void likeSong(Long userId, Long songId);
}
