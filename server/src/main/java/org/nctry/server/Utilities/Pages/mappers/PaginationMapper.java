package org.nctry.server.Utilities.Pages.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nctry.server.Utilities.Pages.response.PaginationResponse;

@Mapper
public interface PaginationMapper {
    PaginationMapper INSTANCE = Mappers.getMapper(PaginationMapper.class);


   /* @Mapping(target = "pageNumber", source = "pageNumber")
    @Mapping(target = "pageSize", source = "pageSize")
    @Mapping(target = "totalElements", source = "totalElements")
    @Mapping(target = "last", source = "last")*/
    PaginationResponse mapToResponse(int pageNumber, int pageSize, long totalElements, boolean last);
}
