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
@Table(name = "comments")
public class Comment extends EntityClass {
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "song_id", nullable = false)
    private Long songId;
    @Column(name = "reply_to_UserId")
    private Long reply_to_userId;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "reactions", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int reactions = 0;
}