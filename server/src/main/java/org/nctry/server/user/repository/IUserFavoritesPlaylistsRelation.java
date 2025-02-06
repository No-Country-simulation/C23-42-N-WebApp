package org.nctry.server.user.repository;

import org.nctry.server.user.model.UserFavoritesPlaylistsRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserFavoritesPlaylistsRelation extends JpaRepository<UserFavoritesPlaylistsRelation, Long> {
}