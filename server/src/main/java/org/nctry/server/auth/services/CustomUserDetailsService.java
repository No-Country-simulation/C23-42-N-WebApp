package org.nctry.server.auth.services;

import lombok.AllArgsConstructor;
import org.nctry.server.user.UserDetailsWrapper;
import org.nctry.server.user.model.User;
import org.nctry.server.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userFound = userRepository.findByUserFullData_Email(email).orElseThrow(() -> new UsernameNotFoundException("Correo no encontrado"));

        return new UserDetailsWrapper(userFound);
    }
}
