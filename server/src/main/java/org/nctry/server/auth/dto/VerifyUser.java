package org.nctry.server.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VerifyUser {
    @NotBlank(message = "¡El campo email no puede estar vacio!")
    @Email(message= "¡El email ingresado no es válido!")
    private String email;

    @NotBlank(message = "EL campo para el codigo de verificacion no puede estar vacio")
    private String verificationCode;
}
