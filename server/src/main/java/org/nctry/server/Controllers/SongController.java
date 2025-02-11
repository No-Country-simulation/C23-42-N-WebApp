package org.nctry.server.Controllers;

import org.nctry.server.Exceptions.ForbiddenException;
import org.nctry.server.Exceptions.UnauthorizedException;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.services.Song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/song")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/get")
    public ResponseEntity<GeneralResponse> getAllActiveSongs(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        try {
            GeneralResponse response = songService.getAllActiveSongs(pageNumber, pageSize, sortBy, sortDir);
            return ResponseEntity.ok(response);
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @GetMapping("/get/name")
    public ResponseEntity<GeneralResponse> getAllActiveSongsByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        try {
            GeneralResponse response = songService.getAllActiveSongsByName(name, pageNumber, pageSize, sortBy, sortDir);
            return ResponseEntity.ok(response);
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @GetMapping("/get/artist")
    public ResponseEntity<GeneralResponse> getAllActiveSongsByArtist(
            @RequestParam String artistName,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        try {
            GeneralResponse response = songService.getAllActiveSongsByArtist(artistName, pageNumber, pageSize, sortBy, sortDir);
            return ResponseEntity.ok(response);
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    /*

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

