package org.nctry.server.post.repository;

import org.nctry.server.post.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepository extends JpaRepository<Like, Long> {
}
