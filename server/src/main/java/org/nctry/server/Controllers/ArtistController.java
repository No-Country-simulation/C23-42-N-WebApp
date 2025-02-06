package org.nctry.server.Controllers;

import org.nctry.server.Utilities.Pages.PaginationUtils;
import org.nctry.server.services.Artist.ArtistService;
import org.nctry.server.song.dto.response.DtoArtist;
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

    /*@PostMapping("/create")
    public ResponseEntity<Object> createArtist(@RequestBody DtoArtist dtoArtist){
        data = new HashMap<>();
        DtoArtist savedArtist = artistService.saveArtist(dtoArtist);
        data.put("message", "Artist created successfully");
        data.put("artist", savedArtist);
        return ResponseEntity.ok(data);
    }*/

    /*
    @PostMapping("/update")
    public ResponseEntity<Object> updateArtist(@RequestBody String artistDTO){
        data = new HashMap<>();
        artistService.saveArtist(artistDTO);
        return ResponseEntity.ok(data);
    }
    */
    @GetMapping("/get")
    public ResponseEntity<Object> getAllArtists(
            @RequestParam(value = "pageNumber", defaultValue = PaginationUtils.DEFECT_PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = PaginationUtils.DEFECT_PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = PaginationUtils.DEFECT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = PaginationUtils.DEFECT_SORT_DIRECTION, required = false) String sortDir
    ){
        return ResponseEntity.ok(artistService.getAllArtists(pageNumber, pageSize, sortBy, sortDir));
    }
    /*
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
    
     */
}
