package com.bavitha.srping.security.securitydemo.Advices;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private LocalDateTime timestamp;
    private T data;
    private ApiError apierror;

    public ApiResponse(){
        this.timestamp= LocalDateTime.now();
    }
    public ApiResponse(T data){
        this();
        this.data=data;
    }
    public ApiResponse(ApiError apiError){
        this.apierror=apiError;
    }
}
