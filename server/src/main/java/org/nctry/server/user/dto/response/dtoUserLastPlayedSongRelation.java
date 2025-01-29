package org.nctry.server.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoUserLastPlayedSongRelation {
    private Long userId;
    private Long songId;
    private int pausedAtSecond;
}