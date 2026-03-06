package com.bavitha.srping.security.securitydemo.Service;


import com.bavitha.srping.security.securitydemo.DTO.PostDTO;
import com.bavitha.srping.security.securitydemo.Entity.PostEntity;
import com.bavitha.srping.security.securitydemo.Exceptions.ResourceNotFound;
import com.bavitha.srping.security.securitydemo.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo repo;
    private final ModelMapper modelMapper;



    public PostDTO createPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(repo.save(postEntity), PostDTO.class);
    }

    public List<PostDTO> getAllPosts() {
        return repo.findAll().stream().map(en-> modelMapper.map(en, PostDTO.class)).toList();
    }

    public PostDTO getPostById(Long postId) {
        PostEntity en= repo.findById(postId).orElseThrow(()-> new ResourceNotFound("post not found"));
        return modelMapper.map(en , PostDTO.class);

    }
}
