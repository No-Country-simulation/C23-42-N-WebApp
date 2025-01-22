package org.nctry.server.services.Song;

public interface SongService {
    void /*SongDTO*/ saveSong(/*SongDTO songDTO*/);
    void deleteSong();
    void deleteSongById(Long id);
    void getSongById(Long id);
    void /*List<SongDTO>*/ getAllSong();
    void /*List<SongDTO>*/ getAllSongByName(String name);
    void /*List<SongDTO>*/ getAllSongByGenre(String genre);
    void likeSong(Long userId, Long songId);
}
