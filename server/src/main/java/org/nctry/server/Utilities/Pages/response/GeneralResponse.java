package org.nctry.server.Utilities.Pages.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GeneralResponse {
    private List<?> content;
    private PaginationResponse pagination;
    private String message;

    public GeneralResponse(String message) {
        this.message = message;
    }
}
