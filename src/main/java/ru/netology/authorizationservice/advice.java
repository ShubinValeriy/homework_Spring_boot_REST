package ru.netology.authorizationservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationservice.exception.InvalidCredentials;
import ru.netology.authorizationservice.exception.UnauthorizedUser;

public class advice {
    @RestControllerAdvice
    public static class MyExceptionHandler {
        @ExceptionHandler(InvalidCredentials.class)
        public ResponseEntity<String> icHandler(InvalidCredentials e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        @ExceptionHandler(UnauthorizedUser.class)
        public ResponseEntity<String> uuHandler(UnauthorizedUser e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
        }
    }
}
