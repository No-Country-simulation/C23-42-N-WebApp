package org.nctry.server.services.Reaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Override
    public void saveReaction(String reactionDTO) {

    }

    @Override
    public void deleteReaction(Long reactionId) {

    }

    @Override
    public List<String> getReactionsByComment(Long commentId) {
        return List.of();
    }

    @Override
    public List<String> getReactionsByPost(Long postId) {
        return List.of();
    }

    @Override
    public void getReactionsByName(String reactionName) {

    }
}
