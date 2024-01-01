package com.microservices.comment.controller;

import com.microservices.comment.entity.comment;
import com.microservices.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class commentController {
    @Autowired
    private CommentService commentService;

    //http://localhost:8082/api/comments
    @PostMapping
    public ResponseEntity<comment> savecomment(@RequestBody comment com){
        comment c = commentService.saveComment(com);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    //http://localhost:8082/api/comments/4a043a71-6c81-458c-a129-727b9caf3f02
    @GetMapping("{postId}")
    public List<comment> getAllCommentsByPostId(@PathVariable String postId){
       List<comment> comments =commentService.getAllCommentsBYPostId(postId);
        return comments;
    }
}
