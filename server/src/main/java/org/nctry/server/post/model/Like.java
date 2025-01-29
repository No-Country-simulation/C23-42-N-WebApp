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
@Table(name = "likes")
public class Like extends EntityClass {
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "song_id", nullable = false)
    private Long songId;
}