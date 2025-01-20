package org.nctry.server.services.Reaction;

import java.util.List;

public interface ReactionService {
    void saveReaction(String reactionDTO);
    void deleteReaction(Long reactionId);
    List<String> getReactionsByComment(Long commentId);
    List<String> getReactionsByPost(Long postId);
    void getReactionsByName(String reactionName);
}
