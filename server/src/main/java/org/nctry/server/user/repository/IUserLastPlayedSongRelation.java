package org.nctry.server.user.repository;

import org.nctry.server.user.model.UserLastPlayedSongRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserLastPlayedSongRelation extends JpaRepository<UserLastPlayedSongRelation, Long> {
}
