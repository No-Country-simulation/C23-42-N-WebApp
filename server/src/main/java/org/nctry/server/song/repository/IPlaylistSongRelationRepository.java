package org.nctry.server.song.repository;

import org.nctry.server.song.model.PlaylistSongRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistSongRelationRepository extends JpaRepository<PlaylistSongRelation, Long> {
}
