package org.nctry.server.song.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.nctry.server.model.EntityClass;

import java.util.Set;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "songs")
public class Song extends EntityClass {
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "cover_picture", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'public/images/defaultCoverPictureSong.jpg'")
    private  String coverPicture;
    @Column(name = "source_url", nullable = false, length = 255)
    private String sourceUrl;
    @Column(name = "artist_id", nullable = false)
    private Long artistId;
    @Column(name = "duration_seconds", nullable = false)
    private int durationSeconds;
    @Column(name = "likes", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int likes = 0;
    @Column(name = "is_public", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED DEFAULT 1")
    private boolean isPublic = true;

    @ManyToMany
    @JoinTable(
            name = "song_genre",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;
}