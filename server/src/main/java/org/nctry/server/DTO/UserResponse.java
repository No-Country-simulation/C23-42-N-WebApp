package org.nctry.server.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.nctry.server.user.dto.response.dtoUser_displayPublicData;
import org.nctry.server.user.model.User;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends GeneralResponse {
    private List<UserDTO> content;
}
