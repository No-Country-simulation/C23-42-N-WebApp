package org.nctry.server.song.repository;

import org.nctry.server.song.dto.response.ArtistProjection;
import org.nctry.server.song.dto.response.DtoArtist;
import org.nctry.server.song.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository  extends JpaRepository<Artist, Long> {
    @Query("SELECT a.name AS name, a.lastname AS lastname, " +
            "a.coverPicture AS coverPicture, a.country AS country, a.bio AS bio " +
            "FROM Artist a")
    Page<ArtistProjection> findAllArtists(Pageable pageable);
}

