package org.nctry.server.song.dto.maps;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.nctry.server.song.dto.response.DtoGenre;
import org.nctry.server.song.model.Genre;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);


    DtoGenre genreToDtoGenre(Genre genre);

    Genre dtoGenreToGenre(DtoGenre dtoGenre);
}
