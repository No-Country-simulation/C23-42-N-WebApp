package org.nctry.server.services.Artist;

import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.response.dtoArtist;

import java.util.List;

public interface ArtistService {
    dtoArtist saveArtist(dtoArtist dtoArtist);
    GeneralResponse getAllArtists(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
}
