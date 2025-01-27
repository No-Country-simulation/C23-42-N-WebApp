package org.nctry.server.auth.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
