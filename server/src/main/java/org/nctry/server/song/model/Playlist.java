package org.nctry.server.song.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.nctry.server.model.EntityClass;

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
}