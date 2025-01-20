package org.nctry.server.services.Artist;

import java.util.List;

public interface ArtistService {
    void saveArtist(String artistDTO);
    void deleteArtist(Long artistId);
    List<String> getAllArtists();
    void getAllArtistsByName(String artistName);
    void getArtistById(Long artistId);
    void getArtistsByGenre(Long genreId);
}
