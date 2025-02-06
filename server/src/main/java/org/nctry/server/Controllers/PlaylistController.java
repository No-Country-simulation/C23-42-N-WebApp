package org.nctry.server.Controllers;

import org.nctry.server.services.Playlist.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/playlist")
public class PlaylistController {
    /*
    private final PlaylistService playlistService;
    private Map<String, Object> data;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPlaylist(){
        data = new HashMap<>();
        playlistService.savePlayList();
        return ResponseEntity.ok(data);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updatePlaylist(){
        data = new HashMap<>();
        playlistService.savePlayList();
        return ResponseEntity.ok(data);
    }

    @PutMapping("/add_song")
    public ResponseEntity<Object> addSongToPlaylist(@RequestParam Long playlistId, @RequestParam Long songId){
        data = new HashMap<>();
        playlistService.addSongToPlaylist(playlistId, songId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllPlaylists(){
        //TODO: Realizar paginacion
        data = new HashMap<>();
        playlistService.getAllPlaylists();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getPlaylistById(@RequestParam Long playlistId){
        data = new HashMap<>();
        playlistService.getPlaylistById(playlistId);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deletePlaylistById(@RequestParam Long playlistId){
        data = new HashMap<>();
        playlistService.deletePlaylistById(playlistId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/remove_song")
    public ResponseEntity<Object> removeSongFromPlaylist(@RequestParam Long playlistId, @RequestParam Long songId){
        data = new HashMap<>();
        playlistService.removeSongFromPlaylist(playlistId, songId);
        return ResponseEntity.ok(data);
    }

     */
}
