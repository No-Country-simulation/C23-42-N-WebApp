package org.nctry.server.song.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nctry.server.user.enums.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoArtist {
    private String name;
    private String lastname;
    private  String coverPicture;
    private Country country;
    private String bio;
}