package org.nctry.server.song.repository;

import org.nctry.server.song.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistRepository  extends JpaRepository<Artist, Long> {
}

