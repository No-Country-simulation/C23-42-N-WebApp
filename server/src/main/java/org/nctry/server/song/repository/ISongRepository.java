package org.nctry.server.song.repository;

import org.nctry.server.song.dto.response.dtoArtist;
import org.nctry.server.song.model.Genre;
import org.nctry.server.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ISongRepository extends JpaRepository<Song, Long> {
    Page<Song> findAllByGenresContains(Genre genre, Pageable pageable);
    Page<Song> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Song> findAllByIsActiveTrue(Pageable pageable);
    Page<Song> findByNameContainingIgnoreCaseAndIsActiveTrue(String name, Pageable pageable);

    Page<Song> findAllByIsActiveTrueAndIsPublicTrue(Pageable pageable);
    Page<Song> findByNameContainingIgnoreCaseAndIsActiveTrueAndIsPublicTrue(String name, Pageable pageable);
    Optional<Song> findByNameAndArtists(String name, Set<dtoArtist> artists);
    Optional<Song> findBySourceUrl(String sourceUrl);
    Page<Song> findByArtists_NameContainingIgnoreCaseAndIsPublicTrue(String artistName, Pageable pageable);
    Page<Song> findByGenres_NameContainingIgnoreCaseAndIsPublicTrue(String genreName, Pageable pageable);
}