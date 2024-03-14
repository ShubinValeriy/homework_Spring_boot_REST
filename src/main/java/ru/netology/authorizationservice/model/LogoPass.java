package ru.netology.authorizationservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class LogoPass {
    @NotBlank
    //логин должен начинаться с латинской буквы, может состоять из латинских букв, цифр
    // и заканчиваться буквой или цифрой. Общая длина не менее 3 символов не более 20
    @Pattern(regexp = "^[A-Za-z]([A-Za-z0-9]{3,18})([A-Za-z0-9])$")
    private final String login;
    @Setter
    //Пароль должен быть не меньше 6 символов и не больше 10, содержать как минимум 1 большую букву,
    // одну маленькую букву и ЛИБО спец. символ ЛИБО цифру
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{6,10}$")
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
