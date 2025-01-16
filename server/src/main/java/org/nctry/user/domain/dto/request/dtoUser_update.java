package org.nctry.user.domain.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.nctry.user.domain.enums.Country;

import java.time.LocalDate;

public record dtoUser_update(
        @NotBlank(message = "¡Debe seleccionar una foto de perfil válida!")
        String profilePicture,
        @NotBlank(message = "¡El campo nombre no puede estar vacio!")
        @Pattern(regexp = "^[a-zA-Z]+$", message = "¡Sólo letras son aceptadas para el campo nombre!")
        String name,
        @NotBlank(message = "¡El campo apellido no puede estar vacio!")
        @Pattern(regexp = "^[a-zA-Z]+$", message = "¡Sólo letras son aceptadas para el campo apellido!")
        String lastName,
        @NotNull(message = "¡El campo fecha de nacimiento no puede estar vacio!")
        @Pattern(regexp = "^[0-9\\-/-]+$", message = "¡Sólo números son aceptados para el campo fecha de nacimiento")
        LocalDate birthday,
        @NotBlank(message = "¡El campo telefono no puede estar vacio!")
        @Pattern(regexp = "^[0-9\\-/-]+$", message = "¡Sólo números son aceptadas para el campo telefono!")
        String phone,
        @NotBlank(message = "¡El campo email no puede estar vacio!")
        String email,
        @NotNull(message = "¡El campo país no puede estar vacio!")
        @Pattern(regexp = "^[A-Za-z]+$", message = "¡Sólo letras son aceptadas!")
        Country country,
        @NotNull(message = "¡El campo ciudad no puede estar vacio!")
        @Pattern(regexp = "^[A-Za-z\\--]+$", message = "¡Sólo letras son aceptadas!")
        Country city
) {}
