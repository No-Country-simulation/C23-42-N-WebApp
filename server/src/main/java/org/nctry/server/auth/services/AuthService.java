package org.nctry.server.auth.services;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.nctry.server.auth.dto.AuthResponse;
import org.nctry.server.auth.dto.LoginRequest;
import org.nctry.server.auth.dto.RegisterRequest;
import org.nctry.server.auth.dto.VerifyUser;
import org.nctry.server.email.EmailService;
import org.nctry.server.user.UserDetailsWrapper;
import org.nctry.server.user.model.User;
import org.nctry.server.user.model.UserFulldata;
import org.nctry.server.user.repository.IUserFullData;
import org.nctry.server.user.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final IUserRepository iUserRepository;
    private final IUserFullData iUserFullData;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final EmailService emailService;

    private UserDetailsWrapper userDetailsWrapper;

    @Transactional
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        //User userFound = userRepository.findByUserFullData_Email(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        UserDetailsWrapper userFound = (UserDetailsWrapper) authentication.getPrincipal();

        String token = jwtService.getToken(userFound);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) { //agregar verificaicon email

        Optional<User> resUser = iUserRepository.findByUsernameOrUserFullData_Email(request.getUsername(), request.getEmail());

        if (resUser.isPresent())
            throw new RuntimeException("El nombre de usuario o correo proporcionado ya existen, intente con otro"); //aqui va excepcion personalizada

        /*String countryName = request.getCountry();
        Country country;

        try {
            if (countryName == null || countryName.isEmpty())
                throw new IllegalArgumentException("Country cannot be null or empty");

            //Verificar si el pais esta en el ENUM
            country = Country.valueOf(countryName.toUpperCase());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid country: " + countryName);
        }*/

        UserFulldata userFulldata = UserFulldata.builder()
                .email(request.getEmail())
                //.birthday(request.getBirthday())
                //.country(country)
                .role(1)
                .confirmationCode(generateVerificationCode())
                .verificationCodeExpiresAt(LocalDateTime.now().plusMinutes(1440)) //expira en 1 dia
                .enabled(false)
                .build();

        User user = User.builder()
                .username(request.getUsername())
                .userFullData(userFulldata)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        iUserFullData.save(userFulldata);
        iUserRepository.save(user);
        sendVerificationEmail(user);

        userDetailsWrapper = new UserDetailsWrapper(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(userDetailsWrapper))
                .build();
    }

    public void verifyUser(VerifyUser verifyUser) {
        Optional<User> optionalUser = iUserRepository.findByUserFullData_Email(verifyUser.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getUserFullData().getVerificationCodeExpiresAt().isBefore(LocalDateTime.now()))
                throw new RuntimeException("EL codigo de verificación ha expirado");

            if (user.getUserFullData().getConfirmationCode().equals(verifyUser.getVerificationCode())) {
                user.getUserFullData().setEnabled(true);
                user.getUserFullData().setConfirmationCode(null);
                user.getUserFullData().setVerificationCodeExpiresAt(null);
                iUserRepository.save(user);
            }
            else {
                throw new RuntimeException("Codigo de verificación invalido");
            }
        }
        else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public void resendVerificationCode(String email) {
        Optional<User> optionalUser = iUserRepository.findByUserFullData_Email(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getUserFullData().isEnabled()) {
                throw new RuntimeException("La cuenta esta verificada");
            }
            user.getUserFullData().setConfirmationCode(generateVerificationCode());
            user.getUserFullData().setVerificationCodeExpiresAt(LocalDateTime.now().plusMinutes(1440)); //expira en 1 dia
            sendVerificationEmail(user);
            iUserRepository.save(user);
        }
        else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public void sendVerificationEmail(User user) {
        String subject = "Account verification";
        String verificationCode = user.getUserFullData().getConfirmationCode();
        String htmlMessage = "<html>"
                + "<body style=\"font-family: Arial, sans-serif;\""
                + "<div style=\"background-color: #f5f5f5; padding: 20px;\">"
                + "<h2 style=\"color: #333;\">Bienvenido!</h2>"
                + "<p style=\"font-size: 16px;\">Por favor ingrese el codigo de verificación para continuar:</p>"
                + "<div style=\"background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1);\">"
                + "<h3 style=\"color: #333;\">Codigo de verificación:</h3>"
                + "<p style=\"font-size: 18px; font-weight: bold; color: #007bff;\">" + verificationCode + "</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        try {
            emailService.sendVerificationEmail(user.getUserFullData().getEmail(), subject, htmlMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}
