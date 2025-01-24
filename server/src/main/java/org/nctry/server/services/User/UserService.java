package org.nctry.server.services.User;

import org.nctry.server.DTO.UserResponse;
import org.nctry.server.user.dto.response.dtoUser_displayPublicData;

import java.util.List;

public interface UserService {
    UserResponse findAll(int pageNumber, int pageSize, String sortBy, String sortDir);
    dtoUser_displayPublicData findByUsername(String username);
    dtoUser_displayPublicData findById(Long Id);
    dtoUser_displayPublicData findByEmail(String email);
}
