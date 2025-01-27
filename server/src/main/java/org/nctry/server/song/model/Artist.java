package org.nctry.server.song.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.nctry.server.model.EntityClass;
import org.nctry.server.user.enums.Country;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
}
