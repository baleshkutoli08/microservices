package com.microservices.post.service;

import com.microservices.post.config.RestTemplateConfig;
import com.microservices.post.entity.Post;
import com.microservices.post.payload.PostDto;
import com.microservices.post.repositry.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public Post savePost(Post post) {
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post saved = postRepository.save(post);
        return saved;
    }


    public Post findPostById(String postId) {
        Optional<Post> postOptional = postRepository.findById(postId);

        // Check if the Optional contains a value before getting it
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            return post;
        } else {
            // Handle the case where the Optional does not contain a value (Post not found)
            // You might throw an exception, return null, or handle it according to your application's logic
            return null; // For instance, returning null here (not recommended in some cases)
        }
    }


    public PostDto getPostWithComments(String postId) {
       Post post= postRepository.findById(postId).get();
        ArrayList comments = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8082/api/comments/" + postId, ArrayList.class);
       PostDto postDto=new PostDto();
       postDto.setPostId(post.getId());
       postDto.setTitle(post.getTitle());
       postDto.setContent(post.getContent());
       postDto.setDescription(post.getDescription());
       postDto.setComments(comments);
       return postDto;

    }
}
