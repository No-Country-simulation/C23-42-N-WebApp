package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoPlaylist;
import org.nctry.server.song.model.Playlist;

@Mapper
public interface PlaylistMapper {
    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "coverPicture", source = "coverPicture")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "isPublic", source = "isPublic")
    dtoPlaylist playlistToDtoPlaylist(Playlist playlist);
}
