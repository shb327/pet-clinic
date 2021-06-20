package com.aboba.petclinic.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Bohdan Shkamarida
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("VET"))) {
            return "redirect:/vet";
        } else {
            return "redirect:/customer";
        }

    }

    /**
     *
     *  Mapping for User Log In
     */

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
