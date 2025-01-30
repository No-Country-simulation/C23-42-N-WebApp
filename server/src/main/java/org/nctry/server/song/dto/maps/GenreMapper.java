package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.dtoGenre;
import org.nctry.server.song.model.Genre;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    dtoGenre genreToDtoGenre(Genre genre);

    Genre dtoGenreToGenre(dtoGenre dtoGenre);
}
