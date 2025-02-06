package org.nctry.server.Utilities.Pages.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private boolean last;
}
