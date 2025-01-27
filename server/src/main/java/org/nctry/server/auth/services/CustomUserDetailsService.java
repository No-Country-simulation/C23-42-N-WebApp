package org.nctry.server.auth.services;

import lombok.AllArgsConstructor;
import org.nctry.server.Exceptions.user.UserNotFoundException;
import org.nctry.server.user.UserDetailsWrapper;
import org.nctry.server.user.model.User;
import org.nctry.server.user.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private final IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
        User userFound = iUserRepository.findByUserFullData_Email(email).orElseThrow(() -> new UserNotFoundException("El usuario con el correo " + email + " no existe"));

        return new UserDetailsWrapper(userFound);
    }
}
