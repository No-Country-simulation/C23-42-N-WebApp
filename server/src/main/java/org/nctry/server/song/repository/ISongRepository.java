package org.nctry.server.song.repository;

import org.nctry.server.song.model.Genre;
import org.nctry.server.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
    @Query("SELECT DISTINCT s FROM Song s " +
            "JOIN FETCH s.genres g " +
            "LEFT JOIN FETCH s.artists a " +
            "LEFT JOIN FETCH s.playlists " +
            "WHERE g = :genre")
    Page<Song> findAllByGenresContains(@Param("genre") Genre genre, Pageable pageable);

    @Query("SELECT DISTINCT s FROM Song s " +
            "LEFT JOIN FETCH s.artists a " +
            "LEFT JOIN FETCH s.genres g " +
            "LEFT JOIN FETCH s.playlists")
    Page<Song> findAllSongs(Pageable pageable);

    @Query("SELECT DISTINCT s FROM Song s " +
            "LEFT JOIN FETCH s.artists a " +
            "LEFT JOIN FETCH s.genres g " +
            "LEFT JOIN FETCH s.playlists " +
            "WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "AND s.isActive = true AND s.isPublic = true")
    Page<Song> findByNameContainingIgnoreCaseAndIsActiveTrueAndIsPublicTrue(
            @Param("name") String name, Pageable pageable);

    @Query("SELECT DISTINCT s FROM Song s " +
            "JOIN s.artists a " +
            "WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :artistName, '%')) " +
            "AND s.isPublic = TRUE")
    Page<Song> findByArtists_NameContainingIgnoreCaseAndIsPublicTrue(
            @Param("artistName") String artistName, Pageable pageable);
}