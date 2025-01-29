package org.nctry.server.song.repository;

import org.nctry.server.song.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepository extends JpaRepository<Playlist, Long> {
}