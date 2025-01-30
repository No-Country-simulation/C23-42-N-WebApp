package org.nctry.server.services.User;

import org.nctry.server.DTO.UserDTO;
import org.nctry.server.Utilities.Pages.response.GeneralResponse;
//import org.nctry.server.user.dto.response.dtoUser_displayPublicData;


public interface UserService {
    GeneralResponse findAll(int pageNumber, int pageSize, String sortBy, String sortDir);
    UserDTO findByUsername(String username);
    UserDTO findById(Long Id);
    UserDTO findByEmail(String email);
}
