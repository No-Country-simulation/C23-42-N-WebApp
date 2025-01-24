package org.nctry.server.auth.services;

import lombok.AllArgsConstructor;
import org.nctry.server.user.UserDetailsWrapper;
import org.nctry.server.user.model.User;
import org.nctry.server.user.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameWithFullData(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new UserDetailsWrapper(user);
    }
}
