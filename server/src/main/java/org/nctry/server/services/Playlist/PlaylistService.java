package org.nctry.server.services.Playlist;

public interface PlaylistService {
    /*PlaylistDTO*/ void savePlayList(/*PlaylistDTO playlistDTO*/);
    void addSongToPlaylist(Long playlistId, Long songId);
    /*PlaylistDTO*/ void getPlaylistById(Long playlistId);
    void getAllPlaylists();
    void removeSongFromPlaylist(Long playlistId, Long songId);
    void deletePlaylistById(Long playlistId);
}
