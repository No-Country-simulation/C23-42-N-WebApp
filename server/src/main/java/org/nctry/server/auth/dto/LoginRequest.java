package org.nctry.server.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequest {
    @NotBlank(message = "¡El campo usuario no puede estar vacio!")
    @Email(message = "Ingrese un email valido")
    String email;
    @NotBlank(message = "¡El campo contraseña no puede estar vacio!")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9\\-_.:!@#$%^&*]{8,16}$",
            message = "La contraseña debe tener entre 8 y 20 caracteres, al menos una letra mayúscula, una letra minúscula, un dígito, y sólo caracteres alfanuméricos o los especiales: - _ . : ! @ # $ % ^ & *"
    )
    String password;
}
