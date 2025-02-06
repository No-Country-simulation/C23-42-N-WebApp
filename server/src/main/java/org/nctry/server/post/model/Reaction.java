package org.nctry.server.post.model;

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
@Table(name = "reactions")
public class Reaction extends EntityClass {
        @Column(name = "name", nullable = false, length = 15)
        private String name;
        @Column(name = "icon", nullable = false, length = 100)
        private String icon;
        @Column(name = "sound")
        private String sound;
}