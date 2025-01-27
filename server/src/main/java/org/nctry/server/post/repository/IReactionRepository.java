package org.nctry.server.post.repository;

import org.nctry.server.post.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReactionRepository extends JpaRepository<Reaction, Long> {
}