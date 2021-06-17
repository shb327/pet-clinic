package com.aboba.petclinic;

import com.aboba.petclinic.model.User;
import com.aboba.petclinic.model.Vet;
import com.aboba.petclinic.service.UserService;
import com.aboba.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetClinicApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private VetService vetService;

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User vetUser = userService.save(User.builder()
//                .username("vet")
//                .password("vet")
//                .authorities("VET")
//                .build());
//        vetService.save(Vet.builder()
//                .user(vetUser)
//                .aboba("obama")
//                .build());
//        userService.save(User.builder()
//                .username("customer")
//                .password("customer")
//                .authorities("CUSTOMER")
//                .build());
    }
}
