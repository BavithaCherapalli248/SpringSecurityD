package com.bavitha.srping.security.securitydemo.Advices;


import com.bavitha.srping.security.securitydemo.Exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse<?>> handleResourNotFound(ResourceNotFound e){
        ApiError apiError = ApiError.builder()
        .status(HttpStatus.NOT_FOUND).message(e.getMessage())
        .build();

        return new ResponseEntity<>(new ApiResponse<>(apiError) , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse<?>> handleAuthenticationException(AuthenticationException e){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.UNAUTHORIZED).message(e.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(new ApiResponse<>(apiError) , apiError.getStatus());
    }




}
