package com.sena.authentication.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource)throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/api/v1/public/**").permitAll() // Public endpoint
                        .requestMatchers("/api/v1/private/**").authenticated() // Private endpoint
                        .anyRequest().authenticated() // Any request to other endpoint need authentication
                )
                .formLogin(withDefaults())
                .build();
    }
}
