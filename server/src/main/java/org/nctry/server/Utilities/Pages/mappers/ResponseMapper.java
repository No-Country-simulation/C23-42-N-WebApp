package org.nctry.server.Utilities.Pages.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;

import java.util.List;

@Mapper
public interface ResponseMapper {
    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    List<Object> toObjectList(List<?> content);

    // Este es el mapeo genérico para la respuesta
    @Mapping(target = "content", source = "content")
    @Mapping(target = "pageNumber", source = "pageNumber")
    @Mapping(target = "pageSize", source = "pageSize")
    @Mapping(target = "totalElements", source = "totalElements")
    @Mapping(target = "last", source = "last")
    GeneralResponse mapToResponse(List<?> content, int pageNumber, int pageSize, long totalElements, boolean last);
}
