package org.nctry.server.services.Artist;

import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.Utilities.Pages.SortUtils;
import org.nctry.server.Utilities.Pages.mappers.PaginationMapper;
import org.nctry.server.Utilities.Pages.mappers.ResponseMapper;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.song.dto.maps.ArtistMapper;
import org.nctry.server.song.dto.response.dtoArtist;
import org.nctry.server.song.model.Artist;
import org.nctry.server.song.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final IArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    //Mapper

    private ArtistMapper artistMapper;


    @Override
    @Cacheable("Saved_Artist")
    public dtoArtist saveArtist(dtoArtist dtoArtist) {
        artistMapper = ArtistMapper.INSTANCE;
        Artist artist = artistMapper.dtoArtistToArtist(dtoArtist);
        artistRepository.save(artist);
        return artistMapper.artistToDtoArtist(artist);
    }


    @Override
    @Cacheable("All_Artists")
    public GeneralResponse getAllArtists(
            Integer pageNumber,
            Integer pageSize,
            String sortBy,
            String sortDir
    ) {
        ResponseMapper responseMapper = ResponseMapper.INSTANCE;
        PaginationMapper paginationMapper = PaginationMapper.INSTANCE;
        artistMapper = ArtistMapper.INSTANCE;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, SortUtils.getSort(pageNumber, pageSize, sortBy, sortDir, "Artist"));
        Page<Artist> artists = artistRepository.findAll(pageable);
        if (artists.isEmpty()) {
            throw new ResourceNotFoundException("Artist", "page", pageNumber.toString());
        }

        return responseMapper.mapToResponse(
                artists.getContent().stream().map(artistMapper::artistToDtoArtist).toList(),
                paginationMapper.mapToResponse(
                        pageNumber,
                        pageSize,
                        artists.getTotalElements(),
                        artists.isLast()
                )
        );
    }
}
