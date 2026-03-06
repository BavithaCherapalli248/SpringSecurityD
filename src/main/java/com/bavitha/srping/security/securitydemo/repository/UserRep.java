package com.bavitha.srping.security.securitydemo.repository;

import com.bavitha.srping.security.securitydemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRep extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}