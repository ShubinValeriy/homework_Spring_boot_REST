package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.LogoPass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository implements AuthRepository{
    private final Map<LogoPass, List<Authorities>> userMap;

    public UserRepository() {
        userMap = new ConcurrentHashMap<>();
    }

    @Override
    public List<Authorities> getAuthorities(String user, String password) {
        LogoPass inputLogoPass = new LogoPass(user,password);
        if (!userMap.containsKey(inputLogoPass)){
            return null;
        }
        return userMap.get(inputLogoPass);
    }
    //For test
    @Override
    public boolean addUser (String user, String password, List<Authorities> list){
        if (!userMap.containsKey(new LogoPass(user,password))){
            userMap.put(new LogoPass(user,password),list);
            return true;
        }
        return false;
    }
    @Override
    public boolean addAdmin (String user, String password, List<Authorities> list){
        if (!userMap.containsKey(new LogoPass(user,password))){
            userMap.put(new LogoPass(user,password),list);
            return true;
        }
        return false;
    }
}
