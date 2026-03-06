package com.bavitha.srping.security.securitydemo.Service;


import com.bavitha.srping.security.securitydemo.DTO.LoginDTO;
import com.bavitha.srping.security.securitydemo.DTO.LoginResponseDTO;
import com.bavitha.srping.security.securitydemo.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final jwtService jwtService;
    private final UserService userService;

    public LoginResponseDTO login(LoginDTO loginDto){
        Authentication authentication = authenticationManager. authenticate(new UsernamePasswordAuthenticationToken( loginDto.getEmail(),loginDto.getPassword()));

        User user = (User)authentication.getPrincipal();
        String token = jwtService.generateToken(user);
            return new LoginResponseDTO(token);
    }
}
