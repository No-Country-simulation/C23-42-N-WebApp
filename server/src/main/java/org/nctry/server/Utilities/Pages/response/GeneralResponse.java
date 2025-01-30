package org.nctry.server.Utilities.Pages.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse {
    private List<Object> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private boolean last;
}
