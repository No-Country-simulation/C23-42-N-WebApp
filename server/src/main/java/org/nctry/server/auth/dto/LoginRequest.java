package org.nctry.server.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequest {
    @NotBlank(message = "¡El campo usuario no puede estar vacio!")
    @Pattern(regexp = "^[a-zA-Z0-9\\-_]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: - _ son aceptados!")
    String email;
    @NotBlank(message = "¡El campo contraseña no puede estar vacio!")
    @Pattern(regexp = "^[a-zA-Z0-9\\-_.:]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: - _ . : son aceptados!")
    String password;
}
