package org.nctry.server.song.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoPlaylist {
    private String name;
    private  String coverPicture;
    private Long userId;
    private boolean isPublic = true;
}