package org.nctry.server.song.dto.response;

import org.nctry.server.song.model.Artist;
import org.nctry.server.user.enums.Country;

public record dtoArtist_displayPublicData(
        String name,
        String lastname,
        String coverPicture,
        Country country,
        String bio
) {
    public dtoArtist_displayPublicData(Artist artist) {
        this(
                artist.getName(),
                artist.getLastname(),
                artist.getCoverPicture(),
                artist.getCountry(),
                artist.getBio()
        );
    }
}