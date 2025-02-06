package org.nctry.server.Utilities.Pages.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.Utilities.Pages.response.PaginationResponse;

@Mapper
public interface PaginationMapper {
    PaginationMapper INSTANCE = Mappers.getMapper(PaginationMapper.class);


    PaginationResponse mapToResponse(int pageNumber, int pageSize, long totalElements, boolean last);
}
