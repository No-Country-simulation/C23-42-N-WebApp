package org.nctry.user.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record dtoUser_login(
        @NotBlank(message = "¡El campo usuario no puede estar vacio!")
        @Pattern(regexp = "^[a-zA-Z0-9\\-_]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: - _ son aceptados!")
        String username,
        @NotBlank(message = "¡El campo contraseña no puede estar vacio!")
        @Pattern(regexp = "^[a-zA-Z0-9\\-_.:]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: - _ . : son aceptados!")
        String password
) {}