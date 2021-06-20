package com.aboba.petclinic.configuration;

import com.aboba.petclinic.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Simple Spring Security domain object implemented for Spring Security Configuration.
 *
 * @author Bohdan Shkamarida
 */

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/vet/**").hasAuthority("VET")
                .antMatchers("/customer**").hasAuthority("CUSTOMER")
                .antMatchers("/css.css", "/logo.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/",true)
                    .failureUrl("/login?error=true")
                    .permitAll()
                .and()
                .csrf().disable();
    }
}
