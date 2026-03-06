package com.bavitha.srping.security.securitydemo.Controller;


import com.bavitha.srping.security.securitydemo.DTO.LoginDTO;
import com.bavitha.srping.security.securitydemo.DTO.LoginResponseDTO;
import com.bavitha.srping.security.securitydemo.DTO.SignUpDTO;
import com.bavitha.srping.security.securitydemo.DTO.UserDTO;
import com.bavitha.srping.security.securitydemo.Service.AuthService;
import com.bavitha.srping.security.securitydemo.Service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;
// sign up controller

   @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO sign){
         UserDTO user = userService.signUp(sign);
         return ResponseEntity.ok(user);
    }
    //login controller


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO login , HttpServletResponse response){
        LoginResponseDTO token = authService.login(login);
        Cookie cookie = new Cookie("token",token.getToken());
        cookie.setHttpOnly(true);
        return ResponseEntity.ok(token);
    }


}
