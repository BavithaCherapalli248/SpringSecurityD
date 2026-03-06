package com.bavitha.srping.security.securitydemo.Controller;


import com.bavitha.srping.security.securitydemo.DTO.PostDTO;
import com.bavitha.srping.security.securitydemo.Service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service){
        this.service=service;
    }

    @PostMapping
    public PostDTO createPost(@RequestBody  PostDTO post){
        return service.createPost(post);
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return service.getPostById(postId);
    }



}
