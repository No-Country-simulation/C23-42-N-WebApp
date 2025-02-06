package org.nctry.server.user.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.nctry.server.user.enums.Country;

import java.time.LocalDate;

@Setter
@Getter
public class dtoUser_create {
    @NotBlank(message = "¡El campo usuario no puede estar vacio!")
    @Pattern(regexp = "^[a-zA-Z0-9\\-_]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: - _ son aceptados!")
    private String username;

    @NotBlank(message = "¡El campo contraseña no puede estar vacio!")
    @Pattern(regexp = "^[A-Za-z0-9.,\\-_$]+$", message = "¡Sólo caracteres alfanúmericos y los caracteres especiales: . , - _ son aceptados!")
    private String password;

    @NotBlank(message = "¡El campo email no puede estar vacio!")
    @Email(message= "¡El email ingresado no es válido!")
    private String email;

    @NotNull(message = "¡El campo fecha de nacimiento no puede estar vacio!")
    @Pattern(regexp = "^[0-9\\-/-]+$", message = "¡Sólo números son aceptados para el campo fecha de nacimiento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past(message = "La fecha de nacimiento debe ser pasado")
    private LocalDate birthday;

    @NotNull(message = "¡El campo país no puede estar vacio!")
    @Pattern(regexp = "^[A-Za-z]+$", message = "¡Sólo letras son aceptadas!")
    private Country country;
}