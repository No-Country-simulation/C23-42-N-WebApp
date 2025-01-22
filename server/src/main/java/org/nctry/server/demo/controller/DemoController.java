package org.nctry.server.demo.controller;


import lombok.RequiredArgsConstructor;
import org.nctry.server.user.UserDetailsWrapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/demo")
    public String welcome() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("No autenticado");
            return "No autenticado";
        }

        UserDetailsWrapper currentUser = (UserDetailsWrapper) authentication.getPrincipal(); //getPrincipal retornar la clase que implementa UserDetails
        System.out.println(currentUser.toString());
        return "Bienvenido " +  currentUser.getUsername();
    }

}
