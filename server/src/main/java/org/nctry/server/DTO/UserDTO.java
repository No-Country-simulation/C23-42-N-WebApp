package org.nctry.server.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private UserFullDataDTO fullData;
    private String username;
    private LocalDateTime lastOnlineAt;
}
