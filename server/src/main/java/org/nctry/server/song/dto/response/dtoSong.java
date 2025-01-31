package org.nctry.server.song.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoSong {
    private String name;
    private  String coverPicture;
    private String sourceUrl;
    private Long artistId;
    private int durationSeconds;
    private int likes = 0;
    private boolean isPublic = true;

}