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
@Table(name = "genres")
public class Genre extends EntityClass {

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;
    @Column(name = "description")
    private  String description;
}