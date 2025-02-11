package org.nctry.server.services.Artist;

import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.response.DtoArtist;

public interface ArtistService {
    //DtoArtist saveArtist(DtoArtist dtoArtist);
    GeneralResponse getAllArtists(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
}
