package org.nctry.server.song.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DtoSong {
    private String name;
    private  String coverPicture;
    private String sourceUrl;
    private Set<DtoArtist> artists;
    private int durationSeconds;
    private int likes = 0;
    private boolean isPublic = true;
}