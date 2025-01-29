package org.nctry.server.user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "user_comment_reaction_relation")
public class UserCommentReactionRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "comment_id", nullable = false)
    private Long commentId;
    @Column(name = "reaction_id", nullable = false)
    private Long reactionId;
}