package com.bavitha.srping.security.securitydemo.repository;

import com.bavitha.srping.security.securitydemo.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<PostEntity , Long> {

}
