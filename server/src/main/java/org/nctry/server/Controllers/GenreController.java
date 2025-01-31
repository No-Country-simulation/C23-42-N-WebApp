package org.nctry.server.Controllers;

import org.nctry.server.Utilities.Pages.PaginationUtils;
import org.nctry.server.services.Genre.GenreService;
import org.nctry.server.song.dto.response.dtoGenre;
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
    public ResponseEntity<Object> createGenre(@RequestBody dtoGenre dtoGenre) {
        data = new HashMap<>();

        return ResponseEntity.ok(genreService.saveGenre(dtoGenre));
    }

    /*
    @PutMapping("/update")
    public ResponseEntity<Object> updateGenre(@RequestBody String genreDTO) {
        data = new HashMap<>();
        genreService.saveGenre(genreDTO);
        return ResponseEntity.ok(data);
    }
    */

    @GetMapping("/get")
    public ResponseEntity<Object> getAllGenre(
            @RequestParam(value = "pageNumber", defaultValue = PaginationUtils.DEFECT_PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = PaginationUtils.DEFECT_PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = PaginationUtils.DEFECT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PaginationUtils.DEFECT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(genreService.getAllGenres(
                pageNumber,
                pageSize,
                sortBy,
                sortDir
        ));
    }

    @GetMapping("/get/songs")
    public ResponseEntity<Object> getAllSongsByGenre(
            @RequestHeader Long genreId,
            @RequestParam(value = "pageNumber", defaultValue = PaginationUtils.DEFECT_PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = PaginationUtils.DEFECT_PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = PaginationUtils.DEFECT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PaginationUtils.DEFECT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(genreService.getSongsByGenre(
                genreId,
                pageNumber,
                pageSize,
                sortBy,
                sortDir
        ));
    }

    @PutMapping("/assign/song")
    public ResponseEntity<Object> assignGenreToSong(@RequestParam Long genreId, @RequestParam Long songId) {
        data = new HashMap<>();
        genreService.assignGenreToSong(genreId, songId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/assign/playlist")
    public ResponseEntity<Object> assignGenreToPlaylist(@RequestParam Long genreId, @RequestParam Long playlistId) {
        data = new HashMap<>();
        genreService.assignGenreToPlaylist(genreId, playlistId);
        return ResponseEntity.ok(data);
    }

    /*
    @PutMapping("/assign")
    public ResponseEntity<Object> assignGenreToArtist(@RequestParam Long genreId, @RequestParam Long artistId) {
        data = new HashMap<>();
        genreService.assignGenreToArtist(genreId, artistId);
        return ResponseEntity.ok(data);
    }
    */

    @PutMapping("/unassign/song")
    public ResponseEntity<Object> unassignGenreToSong(@RequestParam Long genreId, @RequestParam Long songId) {
        data = new HashMap<>();
        genreService.unassignGenreFromSong(genreId, songId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/unassign/playlist")
    public ResponseEntity<Object> unassignGenreToPlaylist(@RequestParam Long genreId, @RequestParam Long playlistId) {
        data = new HashMap<>();
        genreService.unassignGenreFromPlaylist(genreId, playlistId);
        return ResponseEntity.ok(data);
    }

   /* @PutMapping("/unassign")
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
    }*/
}
