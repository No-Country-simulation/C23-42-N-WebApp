package org.nctry.server.services.Post;

public interface PostService {
    void savePost(/*PostDTO postDTO*/);
    void deletePost(Long postId);
    void /*PostDTO*/ getPostById(Long postId);
    void /*List<Post>*/ getPostByTitle(String title);
    void /*List<Post>*/ getPostByUser(/*User*/ String user);
    void /*List<Post>*/ getPostBySong(/*Song*/ String song);
}
