package com.bavitha.srping.security.securitydemo;

import com.bavitha.srping.security.securitydemo.Entity.User;
import com.bavitha.srping.security.securitydemo.Service.jwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecuritydemoApplicationTests {

    @Autowired
    private jwtService jwtService;

	@Test
	void contextLoads() {

        User user = new User(4L , "bavitha","bavitha@gmail.com","bavi234");
        String token= jwtService.generateToken(user);
        System.out.println(token);

        Long id = jwtService.getUserIdFromToken(token);
        System.out.println(id);

	}

}
