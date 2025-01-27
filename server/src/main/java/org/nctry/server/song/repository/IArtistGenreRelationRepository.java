package org.nctry.server.song.repository;

import org.nctry.server.song.model.ArtistGenreRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistGenreRelationRepository extends JpaRepository<ArtistGenreRelation, Long> {
}
