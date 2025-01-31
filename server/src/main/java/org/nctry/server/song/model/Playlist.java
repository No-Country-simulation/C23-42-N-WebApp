package org.nctry.server.song.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "playlists")
public class Playlist extends EntityClass {
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;
    @Column(name = "cover_picture", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'public/images/defaultCoverPicturePlaylist.jpg'")
    private  String coverPicture;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "is_public", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED DEFAULT 1")
    private boolean isPublic = true;

    @ManyToMany
    @JoinTable(
            name = "song_genre",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @JsonManagedReference
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "song_playlist",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    @JsonManagedReference
    private Set<Song> songs;
}