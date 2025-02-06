package org.nctry.server.user.repository;

import org.nctry.server.user.model.UserCommentReactionRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserCommentReactionRelation extends JpaRepository<UserCommentReactionRelation, Long> {
}