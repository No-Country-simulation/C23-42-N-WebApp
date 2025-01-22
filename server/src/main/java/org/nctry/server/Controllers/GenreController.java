package org.nctry.server.Controllers;

import org.nctry.server.services.Genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/genre")
public class GenreController {
    private final GenreService genreService;
    private Map<String, Object> data;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createGenre(@RequestBody String genreDTO) {
        data = new HashMap<>();
        genreService.saveGenre(genreDTO);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateGenre(@RequestBody String genreDTO) {
        data = new HashMap<>();
        genreService.saveGenre(genreDTO);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllGenre() {
        data = new HashMap<>();
        genreService.getAllGenres();
        return ResponseEntity.ok(data);
    }

    @PutMapping("/assign")
    public ResponseEntity<Object> assignGenreToSong(@RequestParam Long genreId, @RequestParam Long songId) {
        data = new HashMap<>();
        genreService.assignGenreToSong(genreId, songId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/assign")
    public ResponseEntity<Object> assignGenreToPlaylist(@RequestParam Long genreId, @RequestParam Long playlistId) {
        data = new HashMap<>();
        genreService.assignGenreToPlaylist(genreId, playlistId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/assign")
    public ResponseEntity<Object> assignGenreToArtist(@RequestParam Long genreId, @RequestParam Long artistId) {
        data = new HashMap<>();
        genreService.assignGenreToArtist(genreId, artistId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/unassign")
    public ResponseEntity<Object> unassignGenreToSong(@RequestParam Long genreId, @RequestParam Long songId) {
        data = new HashMap<>();
        genreService.unassignGenreFromSong(genreId, songId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/unassign")
    public ResponseEntity<Object> unassignGenreToPlaylist(@RequestParam Long genreId, @RequestParam Long playlistId) {
        data = new HashMap<>();
        genreService.unassignGenreFromPlaylist(genreId, playlistId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/unassign")
    public ResponseEntity<Object> unassignGenreToArtist(@RequestParam Long genreId, @RequestParam Long artistId) {
        data = new HashMap<>();
        genreService.unassignGenreFromArtist(genreId, artistId);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteGenre(@RequestParam Long genreId) {
        data = new HashMap<>();
        genreService.deleteGenre(genreId);
        return ResponseEntity.ok(data);
    }
}
