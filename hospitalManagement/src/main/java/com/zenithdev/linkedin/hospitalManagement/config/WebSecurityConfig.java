package com.zenithdev.linkedin.hospitalManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
                )
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("admin")
                .password("adminpass")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("patient")
                .password("patientpass")
                .roles("PATIENT")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
