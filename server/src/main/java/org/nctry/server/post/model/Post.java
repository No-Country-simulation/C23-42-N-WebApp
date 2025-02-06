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
@Table(name = "posts")
public class Post extends EntityClass {
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "song_id", nullable = false)
    private Long songId;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "is_public", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isPublic = true;
}