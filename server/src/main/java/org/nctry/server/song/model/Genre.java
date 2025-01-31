package org.nctry.server.song.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.nctry.server.model.EntityClass;

import java.util.Set;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "genres")
public class Genre extends EntityClass {

    @Column(name = "name", unique = true, length = 50)
    private String name;
    @Column(name = "description")
    private  String description;

    @ManyToMany(mappedBy = "genres")
    private Set<Song> songs;

    @ManyToMany(mappedBy = "genres")
    private Set<Playlist> playlists;
}