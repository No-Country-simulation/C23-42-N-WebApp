package org.nctry.server.Utilities.Pages.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralResponse {
    private List<?> content;
    private PaginationResponse pagination;
}
