package ru.netology.authorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.exception.InvalidCredentials;
import ru.netology.authorizationservice.exception.UnauthorizedUser;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.LogoPass;
import ru.netology.authorizationservice.repository.AuthRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationService {
    private AuthRepository repository;

    public AuthorizationService(AuthRepository repository) {
        this.repository = repository;
    }

    public List<Authorities> getAuthorities(LogoPass logoPass) {
        String user = logoPass.getLogin();
        String password = logoPass.getPassword();
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = repository.getAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    //For test
    public boolean addUser(LogoPass logoPass){
        List<Authorities> userAuthorities = new ArrayList<>();
        userAuthorities.add(Authorities.READ);
        userAuthorities.add(Authorities.WRITE);

        return repository.addUser(
                logoPass.getLogin(),
                logoPass.getPassword(),
                userAuthorities
        );
    }

    public boolean addAdmin(LogoPass logoPass){
        List<Authorities> userAuthorities = new ArrayList<>();
        userAuthorities.add(Authorities.READ);
        userAuthorities.add(Authorities.WRITE);
        userAuthorities.add(Authorities.DELETE);
        return repository.addUser(
                logoPass.getLogin(),
                logoPass.getPassword(),
                userAuthorities);
    }

}
