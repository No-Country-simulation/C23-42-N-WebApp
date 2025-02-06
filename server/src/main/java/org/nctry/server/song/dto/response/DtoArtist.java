package org.nctry.server.song.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DtoArtist {
    private String name;
    private String lastname;
    private String coverPicture;
    private String country;
    private String bio;
}