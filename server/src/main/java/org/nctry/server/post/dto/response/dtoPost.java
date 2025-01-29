package org.nctry.server.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoPost {
    private String title;
    private Long userId;
    private Long songId;
    private String content;
    private boolean isPublic = true;
}