package org.nctry.server.services.Artist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Override
    public void saveArtist(String artistDTO) {

    }

    @Override
    public void deleteArtist(Long artistId) {

    }

    @Override
    public List<String> getAllArtists() {
        return List.of();
    }

    @Override
    public void getAllArtistsByName(String artistName) {

    }

    @Override
    public void getArtistById(Long artistId) {

    }

    @Override
    public void getArtistsByGenre(Long genreId) {

    }


}
