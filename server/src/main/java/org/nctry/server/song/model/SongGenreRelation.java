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
@Table(name = "song_genre_relation")
public class SongGenreRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "song_id", nullable = false)
    private Long songId;
    @Column(name = "genre_id", nullable = false)
    private Long genreId;
}