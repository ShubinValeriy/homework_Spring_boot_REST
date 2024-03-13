package ru.netology.authorizationservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class LogoPass {
    private final String login;
    @Setter
    private String password;

    public LogoPass(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogoPass logoPass)) return false;
        return Objects.equals(getLogin(), logoPass.getLogin()) && Objects.equals(getPassword(), logoPass.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword());
    }

    @Override
    public String toString() {
        return "LogoPass{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
