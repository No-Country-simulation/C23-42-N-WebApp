package org.nctry.server.song.repository;

import org.nctry.server.song.model.PlaylistGenreRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistGenreRelationRepository extends JpaRepository<PlaylistGenreRelation, Long> {
}