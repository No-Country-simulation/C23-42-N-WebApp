package org.nctry.server.Controllers;

import org.nctry.server.services.Artist.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/artist")
public class ArtistController {
    private final ArtistService artistService;
    private Map<String, Object> data;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createArtist(@RequestBody String artistDTO){
        data = new HashMap<>();
        artistService.saveArtist(artistDTO);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateArtist(@RequestBody String artistDTO){
        data = new HashMap<>();
        artistService.saveArtist(artistDTO);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllArtists(){
        data = new HashMap<>();
        artistService.getAllArtists();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllArtistsByName(@RequestParam String artistName){
        data = new HashMap<>();
        artistService.getAllArtistsByName(artistName);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getArtistById(@RequestParam Long artistId){
        data = new HashMap<>();
        artistService.getArtistById(artistId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getArtistsByGenres(@RequestParam Long genreId){
        data = new HashMap<>();
        artistService.getArtistsByGenre(genreId);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteArtistById(@RequestParam Long artistId){
        data = new HashMap<>();
        artistService.deleteArtist(artistId);
        return ResponseEntity.ok(data);
    }
}
