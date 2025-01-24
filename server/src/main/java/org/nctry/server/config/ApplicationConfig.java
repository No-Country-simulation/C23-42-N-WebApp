
package org.nctry.server.config;

<<<<<<< HEAD
import org.nctry.server.auth.services.CustomUserDetailsService;
=======
import org.nctry.server.user.UserDetailsWrapper;
import org.nctry.server.user.repository.IUserRepository;
>>>>>>> develop
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

<<<<<<< HEAD
    //private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public ApplicationConfig(CustomUserDetailsService customUserDetailsService) {
        //this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
=======
    private final IUserRepository userRepository;

    @Autowired
    public ApplicationConfig(IUserRepository userRepository) {
        this.userRepository = userRepository;
>>>>>>> develop
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setUserDetailsService(customUserDetailsService);

        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return  authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public UserDetailsService userDetailService() {
        return username -> userRepository.findByUsername(username)
                .map(UserDetailsWrapper::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found exception"));
    }*/

}
