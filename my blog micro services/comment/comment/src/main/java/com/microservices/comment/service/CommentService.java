package com.microservices.comment.service;

import com.microservices.comment.config.RestTemplateConfig;
import com.microservices.comment.entity.comment;
import com.microservices.comment.payload.Post;
import com.microservices.comment.repository.commentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CommentService {
    @Autowired
    private commentRepository commentRepository;
    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public comment saveComment(comment com){
        Post post=restTemplateConfig.getRestTemplate().getForObject("http://localhost:8081/api/posts/"+com.getPostId(), Post.class);

        if(post!=null){
          String commentId= UUID.randomUUID().toString();
          com.setId(commentId);
            comment saved= commentRepository.save(com);
            return saved;
        }else {
            System.out.println("no post");
            return null;

        }


    }

    public List<comment> getAllCommentsBYPostId(String postId) {
        List<comment> comments=commentRepository.findByPostId(postId);
        return comments;
    }
}
