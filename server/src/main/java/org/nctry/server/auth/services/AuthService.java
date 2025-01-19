package org.nctry.server.auth.services;

import lombok.RequiredArgsConstructor;
import org.nctry.server.auth.dto.AuthResponse;
import org.nctry.server.auth.dto.LoginRequest;
import org.nctry.server.auth.dto.RegisterRequest;
import org.nctry.server.user.UserDetailsWrapper;
import org.nctry.server.user.entity.User;
import org.nctry.server.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private UserDetailsWrapper userDetailsWrapper;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Verifica que la contraseña ingresada coincide con la almacenada
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        userDetailsWrapper = new UserDetailsWrapper(user);

        String token = jwtService.getToken(userDetailsWrapper);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .country(request.getCountry())
                .role(1)
                .build();

        userRepository.save(user);

        userDetailsWrapper = new UserDetailsWrapper(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(userDetailsWrapper))
                .build();
    }
}
