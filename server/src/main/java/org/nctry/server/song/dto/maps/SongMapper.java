package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoSong;
import org.nctry.server.song.model.Song;

@Mapper
public interface SongMapper {
    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "coverPicture", source = "coverPicture")
    @Mapping(target = "sourceUrl", source = "sourceUrl")
    @Mapping(target = "durationSeconds", source = "durationSeconds")
    @Mapping(target = "likes", source = "likes")
    @Mapping(target = "isPublic", source = "isPublic")
    @Mapping(target = "genres", source = "genres")
    @Mapping(target = "playlists", source = "playlists")
    @Mapping(target = "artists", source = "artists")
    dtoSong songToDtoSong(Song song);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "coverPicture", source = "coverPicture")
    @Mapping(target = "sourceUrl", source = "sourceUrl")
    @Mapping(target = "durationSeconds", source = "durationSeconds")
    @Mapping(target = "likes", source = "likes")
    @Mapping(target = "isPublic", source = "isPublic")
    @Mapping(target = "genres", source = "genres")
    @Mapping(target = "playlists", source = "playlists")
    @Mapping(target = "artists", source = "artists")
    Song dtoSongToSong(dtoSong dtoSong);
}
