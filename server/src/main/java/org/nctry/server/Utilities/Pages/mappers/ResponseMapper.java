package org.nctry.server.Utilities.Pages.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
import org.nctry.server.Utilities.Pages.response.PaginationResponse;

import java.util.List;

@Mapper
public interface ResponseMapper {
    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    List<Object> toObjectList(List<?> content);


    @Mapping(target = "pagination", source = "pagination")
    @Mapping(target = "content", source = "content")
    GeneralResponse mapToResponse(List<?> content, PaginationResponse pagination);
}
