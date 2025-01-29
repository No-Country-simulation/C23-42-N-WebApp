package org.nctry.server.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoUserCommentReactionRelation {
    private Long userId;
    private Long commentId;
    private Long reactionId;
}