package org.nctry.server.Controllers;

import org.nctry.server.Exceptions.ForbiddenException;
import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.Exceptions.UnauthorizedException;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.services.Song.SongService;
import org.nctry.server.song.dto.response.dtoSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/song")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/all")
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

    @GetMapping("/all/name")
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

    @GetMapping("/all/artist")
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

    @GetMapping("/song/{id}")
    public ResponseEntity<dtoSong> getSongById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            dtoSong song = songService.getSongById(id);
            return ResponseEntity.ok(song);
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @PostMapping("song")
    public ResponseEntity<dtoSong> createSong(@RequestBody dtoSong dtoNewSong) {
        if (dtoNewSong == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            dtoSong createdSong = songService.saveSong(dtoNewSong);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSong);
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @DeleteMapping("/song")
    public ResponseEntity<Void> deleteSongByNameAndArtist(@RequestBody dtoSong dtoSong) {
        if (dtoSong == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            songService.deleteSongByNameAndArtist(dtoSong);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<Void> deleteSongById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            songService.deleteSongById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @DeleteMapping("/song/wipe/{id}")
    public ResponseEntity<Void> wipeSongById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            songService.wipeSongById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @DeleteMapping("/song/wipe/name-artist")
    public ResponseEntity<Void> wipeSongByNameAndArtist(@RequestBody dtoSong dtoSong) {
        if (dtoSong == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            songService.wipeSongByNameAndArtist(dtoSong);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }

    @PostMapping("/like")
    public ResponseEntity<Void> likeSong(@RequestParam Long userId, @RequestParam Long songId) {
        if (userId == null || songId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            songService.likeSong(userId, songId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (UnauthorizedException ex) {
            throw new UnauthorizedException("¡Necesitas estar conectado para ver este contenido!");
        } catch (ForbiddenException ex) {
            throw new ForbiddenException("¡Necesitas estar conectado para ver este contenido!");
        }
    }
}

