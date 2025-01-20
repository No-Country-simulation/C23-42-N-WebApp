package org.nctry.server.Controllers;

import org.nctry.server.services.Reaction.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.nctry.server.Controllers.ApiPaths.ROOT;

@RestController
@RequestMapping(ROOT + "/reaction")
public class ReactionController {
    private final ReactionService reactionService;
    private Map<String, Object> data;

    @Autowired
    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createReaction(String reactionDTO) {
        data = new HashMap<>();
        reactionService.saveReaction(reactionDTO);
        return ResponseEntity.ok(data);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateReaction(String reactionDTO) {
        data = new HashMap<>();
        reactionService.saveReaction(reactionDTO);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getReactionByComment(@RequestParam Long commentId) {
        data = new HashMap<>();
        reactionService.getReactionsByComment(commentId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getReactionByPost(@RequestParam Long postId) {
        data = new HashMap<>();
        reactionService.getReactionsByPost(postId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getReactionsByName(@RequestParam String name) {
        data = new HashMap<>();
        reactionService.getReactionsByName(name);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteReaction(@RequestParam Long reactionId) {
        data = new HashMap<>();
        reactionService.deleteReaction(reactionId);
        return ResponseEntity.ok(data);
    }
}
