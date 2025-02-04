package org.nctry.server.song.repository;

import org.nctry.server.song.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(String name);
}