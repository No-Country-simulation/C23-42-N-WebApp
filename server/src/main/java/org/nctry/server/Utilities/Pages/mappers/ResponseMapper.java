package org.nctry.server.Utilities.Pages.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;

import java.util.List;

@Mapper
public interface ResponseMapper {
    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    GeneralResponse mapToResponse(List<?> content, int pageNumber, int pageSize, long totalElements, boolean last);
}
