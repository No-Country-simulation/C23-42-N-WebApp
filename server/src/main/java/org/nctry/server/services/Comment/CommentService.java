package org.nctry.server.services.Comment;

public interface CommentService {
    void saveComment(/*Comment*/ String comment);
    void deleteComment(Long commentId);
    void getCommentByPost(/*Post*/ String post);
    void getCommentById(Long user);
    void getRepliesToComment(Long commentId);
    void addRepliesToComment(Long commentId);
    void addReactionToComment(Long commentId, String reaction, Long userId);
}
