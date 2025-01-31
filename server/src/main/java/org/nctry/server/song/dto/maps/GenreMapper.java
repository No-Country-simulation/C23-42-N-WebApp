package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoGenre;
import org.nctry.server.song.model.Genre;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    dtoGenre genreToDtoGenre(Genre genre);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    Genre dtoGenreToGenre(dtoGenre dtoGenre);
}
