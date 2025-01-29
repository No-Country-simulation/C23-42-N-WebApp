package org.nctry.server.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoComment {
    private Long userId;
    private Long songId;
    private Long reply_to_userId;
    private String content;
    private int reactions = 0;
}