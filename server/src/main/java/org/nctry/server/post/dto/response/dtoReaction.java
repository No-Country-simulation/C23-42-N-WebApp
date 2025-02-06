package org.nctry.server.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoReaction {
    private String name;
    private String icon;
    private String sound;
}