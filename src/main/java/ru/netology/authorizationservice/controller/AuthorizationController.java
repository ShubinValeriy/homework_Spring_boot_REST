package ru.netology.authorizationservice.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.annotation.LogoPassAnnotation;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.LogoPass;
import ru.netology.authorizationservice.service.AuthorizationService;

import java.util.List;

@Validated
@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(
            @Valid @LogoPassAnnotation LogoPass logoPass
    ) {
        return service.getAuthorities(logoPass);
    }

    //For test
    @GetMapping("/add/user")
    public boolean addUser(
            @Valid @LogoPassAnnotation LogoPass logoPass
    ) {
        return service.addUser(logoPass);
    }

    @GetMapping("/add/admin")
    public boolean addAdmin(
            @Valid @LogoPassAnnotation LogoPass logoPass
    ) {
        return service.addAdmin(logoPass);
    }
}
