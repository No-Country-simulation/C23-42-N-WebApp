package org.nctry.server.Utilities.Pages.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponse {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private boolean last;
}
