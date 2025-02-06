package org.nctry.server.Controllers;

import org.nctry.server.services.Post.PostService;
import org.nctry.server.services.Song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/post")
public class PostController {
    /*
    private final PostService postService;
    private final SongService songService;
    private Map<String, Object> data;

    @Autowired
    public PostController(PostService postService, SongService songService) {
        this.postService = postService;
        this.songService = songService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPost(@RequestBody/*PostDTO*/ /*String postDTO) {
        data = new HashMap<>();
        postService.savePost();
        return ResponseEntity.ok(data);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updatePost(@RequestBody String postDTO) {
        data = new HashMap<>();
        postService.savePost();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getPostById(@RequestParam Long postId) {
        data = new HashMap<>();
        postService.getPostById(postId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getPostByTitle(@RequestParam String title) {
        data = new HashMap<>();
        postService.getPostByTitle(title);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getPostByUser(@RequestParam Long userId) {
        data = new HashMap<>();
        //Obtengo el user
        String user = "";
        postService.getPostByUser(user);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getPostBySong(@RequestParam Long songId) {
        data = new HashMap<>();
        String song = "";//songService.getSongById(songId);
        postService.getPostBySong(song);
        return ResponseEntity.ok(data);
    }
    */
}
