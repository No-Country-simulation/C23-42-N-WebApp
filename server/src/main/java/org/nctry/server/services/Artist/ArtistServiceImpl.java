package org.nctry.server.services.Artist;

import org.nctry.server.Exceptions.ResourceNotFoundException;
import org.nctry.server.Utilities.Pages.SortUtils;
import org.nctry.server.Utilities.Pages.mappers.PaginationMapper;
import org.nctry.server.Utilities.Pages.mappers.ResponseMapper;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.Utilities.Pages.response.PaginationResponse;
import org.nctry.server.minio.services.MinioManager;
import org.nctry.server.song.dto.maps.ArtistMapper;
import org.nctry.server.song.dto.response.ArtistProjection;
import org.nctry.server.song.dto.response.DtoArtist;
import org.nctry.server.song.model.Artist;
import org.nctry.server.song.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final IArtistRepository artistRepository;

    //Minio Manager
    private final MinioManager minioManager;

    @Autowired
    public ArtistServiceImpl(IArtistRepository artistRepository, MinioManager minioManager) {
        this.artistRepository = artistRepository;
        this.minioManager = minioManager;
    }
    //Mapper

    private ArtistMapper artistMapper;


    /*@Override
    @Cacheable("Saved_Artist")
    public DtoArtist saveArtist(DtoArtist dtoArtist) {
        artistMapper = ArtistMapper.INSTANCE;
        Artist artist = artistMapper.dtoArtistToArtist(dtoArtist);
        artistRepository.save(artist);
        return artistMapper.artistToDtoArtist(artist);
    }*/


    @Override
    //@Cacheable("All_Artists")
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
        Page<ArtistProjection> artists = artistRepository.findAllArtists(pageable);
        if (artists.isEmpty()) {
            throw new ResourceNotFoundException("Artist", "page", pageNumber.toString());
        }

        List<DtoArtist> artistDtos = artists.getContent().stream()
                .map(artist -> DtoArtist.builder()
                        .name(artist.getName())
                        .lastname(artist.getLastname())
                        .coverPicture(minioManager.getPresignedUrl(artist.getCoverPicture()))
                        .country(artist.getCountry())
                        .bio(artist.getBio())
                        .build())
                .toList();

        return GeneralResponse.builder()
                .content(artistDtos)
                .pagination(PaginationResponse.builder()
                        .pageNumber(pageNumber)
                        .pageSize(pageSize)
                        .totalElements(artists.getTotalElements())
                        .last(artists.isLast())
                        .build())
                .build();

        /*return responseMapper.mapToResponse(
                artists.getContent().stream().map(artistMapper::artistToDtoArtist).toList(),
                paginationMapper.mapToResponse(
                        pageNumber,
                        pageSize,
                        artists.getTotalElements(),
                        artists.isLast()
                )
        );*/
    }
}
