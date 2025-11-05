package com.caro.recipe_app_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF-Schutz deaktivieren für API-POSTs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()  // <-- alle API-Endpunkte freigeben
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults()); // optional: einfache Authentifizierung aktiv lassen
        return http.build();
    }
}
