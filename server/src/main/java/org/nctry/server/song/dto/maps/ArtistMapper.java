package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoArtist;
import org.nctry.server.song.model.Artist;

@Mapper(componentModel = "spring", uses = {SongMapper.class, GenreMapper.class, PlaylistMapper.class})
public interface ArtistMapper {
    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    dtoArtist artistToDtoArtist(Artist artist);

    Artist dtoArtistToArtist(dtoArtist dtoArtist);
}
