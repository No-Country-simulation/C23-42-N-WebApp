package org.nctry.server.user.repository;

import org.nctry.server.user.model.UserFriendsRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserFriendsRelation extends JpaRepository<UserFriendsRelation, Long> {
}
