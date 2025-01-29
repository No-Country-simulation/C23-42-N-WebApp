package org.nctry.server.auth.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import org.nctry.server.user.enums.Country;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "¡El campo usuario no puede estar vacio!")
    @Pattern(
            regexp = "^[a-zA-Z0-9\\-_.:!@#$%^&*]{4,16}$",
            message = "El nombre de usuario debe tener entre 4 y 16 caracteres, y solo se permiten los caracteres especiales: - _ . : ! @ # $ % ^ & * son aceptados!"
    )
    private String username;

    @NotBlank(message = "¡El campo contraseña no puede estar vacio!")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9\\-_.:!@#$%^&*]{8,16}$",
            message = "La contraseña debe tener entre 8 y 20 caracteres, al menos una letra mayúscula, una letra minúscula, un dígito, y sólo caracteres alfanuméricos o los especiales: - _ . : ! @ # $ % ^ & *"
    )
    private String password;

    @NotBlank(message = "¡El campo email no puede estar vacio!")
    @Email(message= "¡El email ingresado no es válido!")
    private String email;

    /*@NotNull(message = "¡El campo fecha de nacimiento no puede estar vacio!")
    @Pattern(regexp = "^[0-9\\-/-]+$", message = "¡Sólo números son aceptados para el campo fecha de nacimiento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past(message = "La fecha de nacimiento debe ser pasado")
    private LocalDate birthday;*/

    /*@NotNull(message = "¡El campo país no puede estar vacio!")
    @Pattern(regexp = "^[A-Za-z]+$", message = "¡Sólo letras son aceptadas!")
    private String country;*/
}
