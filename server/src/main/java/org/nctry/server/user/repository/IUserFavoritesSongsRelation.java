package org.nctry.server.user.repository;

import org.nctry.server.user.model.UserFavoritesSongsRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserFavoritesSongsRelation extends JpaRepository<UserFavoritesSongsRelation, Long>{
}