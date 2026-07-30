package br.com.vitorcarvalho.order_management_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    private final static String[] PERMIT_ALL_LIST = {
        "/swagger-ui/**",
        "/swagger-resources/**",
        "/v3/api-docs/**"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> {
            auth.requestMatchers("/users").permitAll()
                .requestMatchers("/items").permitAll()
                .requestMatchers(PERMIT_ALL_LIST).permitAll();
        });

        return http.build();
    }
}
