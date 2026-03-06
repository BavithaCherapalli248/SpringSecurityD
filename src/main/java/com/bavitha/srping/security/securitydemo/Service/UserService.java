package com.bavitha.srping.security.securitydemo.Service;


import com.bavitha.srping.security.securitydemo.DTO.SignUpDTO;
import com.bavitha.srping.security.securitydemo.DTO.UserDTO;
import com.bavitha.srping.security.securitydemo.Entity.User;
import com.bavitha.srping.security.securitydemo.repository.UserRep;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {

    private final UserRep userRepo;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  userRepo.findByEmail(username).orElseThrow(()-> new BadCredentialsException("User with email "+ username+ "not found"));
    }


    public UserDTO signUp(SignUpDTO signup){
        Optional<User> user= userRepo.findByEmail(signup.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User already exists"+ signup.getEmail());
        }

       User newUser= mapper.map(signup, User.class);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
       User savedUser=  userRepo.save(newUser);
       return mapper.map(savedUser, UserDTO.class);

    }

}
