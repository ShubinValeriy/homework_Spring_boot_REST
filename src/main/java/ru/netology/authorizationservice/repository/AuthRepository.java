package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.Authorities;

import java.util.List;


public interface AuthRepository {
    List<Authorities> getAuthorities(String user, String password);

    //For test
    boolean addUser(String user, String password, List<Authorities> list);

    boolean addAdmin(String user, String password, List<Authorities> list);

}
