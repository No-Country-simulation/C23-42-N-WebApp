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
@Table(name = "artist_genre_relation")
public class ArtistGenreRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "artist_id", nullable = false)
    private Long artistsId;
    @Column(name = "genre_id", nullable = false)
    private Long genreId;
}