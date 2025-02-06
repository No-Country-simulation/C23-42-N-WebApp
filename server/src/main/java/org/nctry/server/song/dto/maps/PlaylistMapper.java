package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoPlaylist;
import org.nctry.server.song.model.Playlist;

@Mapper
public interface PlaylistMapper {
    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    dtoPlaylist playlistToDtoPlaylist(Playlist playlist);
}
