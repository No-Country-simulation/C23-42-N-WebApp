package org.nctry.server.song.repository;

import org.nctry.server.song.model.Genre;
import org.nctry.server.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
    Page<Song> findAllByGenresContains(Genre genre, Pageable pageable);
}