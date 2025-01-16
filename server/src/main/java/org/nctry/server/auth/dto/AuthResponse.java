package org.nctry.server.auth.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;
}
