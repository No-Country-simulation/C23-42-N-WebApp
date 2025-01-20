package org.nctry.server.Controllers;

import org.nctry.server.services.Comment.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/comment")
public class CommentController {
    private final CommentService commentService;
    private Map<String, Object> data;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createComment(@RequestBody String comment) {
        data = new HashMap<>();
        commentService.saveComment(comment);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateComment(@RequestBody String comment) {
        data = new HashMap<>();
        commentService.saveComment(comment);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getCommentById(@RequestParam Long id) {
        data = new HashMap<>();
        commentService.getCommentById(id);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getCommentByPost() {
        data = new HashMap<>();
        String post = "";
        commentService.getCommentByPost(post);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/replies/get")
    public ResponseEntity<Object> getRepliesToComment(@RequestParam Long commentId) {
        data = new HashMap<>();
        commentService.getRepliesToComment(commentId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/replies/get")
    public ResponseEntity<Object> addRepliesByPost(@RequestParam Long commentId) {
        data = new HashMap<>();
        commentService.addRepliesToComment(commentId);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/replies/get")
    public ResponseEntity<Object> addReactionToComment(@RequestParam Long commentId, @RequestBody String reaction, Long userId) {
        data = new HashMap<>();
        commentService.addReactionToComment(commentId, reaction, userId);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCommentById(@RequestParam Long commentId) {
        data = new HashMap<>();
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(data);
    }
}
