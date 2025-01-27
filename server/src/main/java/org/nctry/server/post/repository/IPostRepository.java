package org.nctry.server.post.repository;

import org.nctry.server.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {
}