package com.aboba.petclinic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Simple Spring Security domain object implemented for password encoding.
 *
 * @author Bohdan Shkamarida
 */

@Configuration
public class PasswordEncoderConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
