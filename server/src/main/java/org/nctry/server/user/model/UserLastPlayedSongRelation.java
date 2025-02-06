package org.nctry.server.user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "user_last_played_song_relation")
public class UserLastPlayedSongRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "song_id", nullable = false)
    private Long songId;
    @Column(name = "paused_at_second", nullable = false)
    private int pausedAtSecond;
}
