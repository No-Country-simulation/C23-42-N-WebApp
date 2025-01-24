package org.nctry.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final CustomCorsConfiguration customCorsConfiguration;

    @Autowired
    public SecurityConfig(JwtRequestFilter jwtAuthenticationFilter, AuthenticationProvider authenticationProvider, CustomCorsConfiguration customCorsConfiguration) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationProvider = authenticationProvider;
        this.customCorsConfiguration = customCorsConfiguration;
    }

    //cadena de filtros = middleware

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authrequest ->
                            authrequest
                                    .requestMatchers("/auth/**").permitAll()
                                    .anyRequest().authenticated()
                        )
                .cors(c -> c.configurationSource(customCorsConfiguration))
                .sessionManagement(sessionManager ->
                            sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
}

