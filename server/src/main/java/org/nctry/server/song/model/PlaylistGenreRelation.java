package org.nctry.server.song.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "playlist_genre_relation")
public class PlaylistGenreRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "playlist_id", nullable = false)
    private Long playlistId;
    @Column(name = "genre_id", nullable = false)
    private Long genreId;
}

