package org.nctry.server.auth.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.nctry.server.auth.dto.AuthResponse;
import org.nctry.server.auth.dto.LoginRequest;
import org.nctry.server.auth.dto.RegisterRequest;
//import org.nctry.server.auth.dto.VerifyUser;
import org.nctry.server.auth.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) { //valid es para validar el formato del json en funcion del dto;
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /*@PostMapping(value = "verify")
    public ResponseEntity<?> verifyUser(@RequestBody VerifyUser verifyUserDto) {
        try {
            authService.verifyUser(verifyUserDto);
            return ResponseEntity.ok("Cuenta verificada satisfactoriamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping(value = "resend")
    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
        try {
            authService.resendVerificationCode(email);
            return ResponseEntity.ok("Codigo de verificación enviado");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
