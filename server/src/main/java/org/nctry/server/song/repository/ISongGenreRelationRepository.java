package org.nctry.server.song.repository;

import org.nctry.server.song.model.SongGenreRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongGenreRelationRepository extends JpaRepository<SongGenreRelation, Long> {
}