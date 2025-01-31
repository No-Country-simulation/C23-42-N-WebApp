package org.nctry.server.Utilities.Pages;

import org.nctry.server.Exceptions.ResourceNotFoundException;

import org.springframework.data.domain.Sort;

public class SortUtils {

    public static Sort getSort(Integer pageNumber, Integer pageSize, String sortBy, String sortDir, String e){
        if (pageSize > 20) {
            throw new ResourceNotFoundException(e, "pageSize", pageSize.toString());
        }
        return sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
    }


}
