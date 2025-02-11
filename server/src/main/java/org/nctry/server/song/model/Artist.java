package org.nctry.server.song.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.nctry.server.model.EntityClass;
import org.nctry.server.user.enums.Country;

import java.util.Set;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, exclude = {"songs"})
@Table(name = "artists")
public class Artist extends EntityClass {
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;
    @Column(name = "lastname", nullable = false, unique = true, length = 50)
    private String lastname;
    @Column(name = "cover_picture", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'public/images/defaultCoverPictureArtist.jpg'")
    private  String coverPicture;
    @Column(name = "country", nullable = false, length = 50)
    private Country country;
    @Column(name = "bio")
    private String bio;

    @ManyToMany
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    //@JsonManagedReference
    @JsonIgnore
    private Set<Song> songs;
}
