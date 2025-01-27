package org.nctry.server.Controllers;

import org.nctry.server.services.Song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/song")
public class SongController {
    /*
}
    private final SongService songService;
    private Map<String, Object> data;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createSong(@RequestBody String songDTO) {
        data = new HashMap<>();

        songService.saveSong();

        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateSong(@RequestBody String songDTO) {
        data = new HashMap<>();
        songService.saveSong();
        return null;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllSong() {
        data = new HashMap<>();
        songService.getAllSong();
        return null;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getSongById(@RequestParam("id") Long id) {
        data = new HashMap<>();
        songService.getSongById(id);
        return null;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getSongByName(@RequestParam("name") String name) {
        data = new HashMap<>();
        songService.getAllSongByName(name);
        return null;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getSongBySongId(@RequestParam("genre") String genre) {
        data = new HashMap<>();
        songService.getAllSongByGenre(genre);
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteSongById(@RequestParam("id") Long id) {
        data = new HashMap<>();
        songService.deleteSongById(id);
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteSongBySongId(@RequestBody String songDTO) {
        data = new HashMap<>();
        songService.deleteSong();
        return null;
    */
}
