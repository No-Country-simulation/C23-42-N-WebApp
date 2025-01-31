package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoSong;
import org.nctry.server.song.model.Song;

@Mapper
public interface SongMapper {
    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    dtoSong songToDtoSong(Song song);
}
