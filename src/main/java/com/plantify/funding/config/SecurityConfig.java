package com.plantify.funding.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        // /fundings 및 /fundings/* - GET
                        .requestMatchers(HttpMethod.GET, "/fundings", "/fundings/*")
                        .hasAnyRole("USER", "MANAGER", "ADMIN")

                        // /fundings/** - POST, PUT, DELETE
                        .requestMatchers(HttpMethod.POST, "/fundings/**")
                        .hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/fundings/**")
                        .hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/fundings/**")
                        .hasAnyRole("MANAGER", "ADMIN")

                        // /fundings/my-fundings/** - GET, POST, DELETE
                        .requestMatchers(HttpMethod.GET, "/fundings/my-fundings/**")
                        .hasAnyRole("USER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/fundings/my-fundings/**")
                        .hasAnyRole("USER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/fundings/my-fundings/**")
                        .hasAnyRole("USER", "MANAGER", "ADMIN")

                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
