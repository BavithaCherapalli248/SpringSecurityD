package com.bavitha.srping.security.securitydemo.Advices;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiError {
   // this is api errro code
    // written by nikhitha
    private HttpStatus status;
    private String message;
    private List<String> suberror;



}
