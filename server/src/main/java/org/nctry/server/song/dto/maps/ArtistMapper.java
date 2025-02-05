package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoArtist;
import org.nctry.server.song.model.Artist;

@Mapper
public interface ArtistMapper {
    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "coverPicture", target = "coverPicture")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "bio", target = "bio")
    @Mapping(source = "songs", target = "songs")
    @Mapping(source = "genres", target = "genres")
    @Mapping(source = "playlists", target = "playlists")
    dtoArtist artistToDtoArtist(Artist artist);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "coverPicture", target = "coverPicture")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "bio", target = "bio")
    @Mapping(source = "songs", target = "songs")
    @Mapping(source = "genres", target = "genres")
    @Mapping(source = "playlists", target = "playlists")
    Artist dtoArtistToArtist(dtoArtist dtoArtist);
}
