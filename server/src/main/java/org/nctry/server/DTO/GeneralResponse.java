package org.nctry.server.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class GeneralResponse {
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private boolean last;
}
