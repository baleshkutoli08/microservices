package com.microservices.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.comment.entity.comment;

import java.util.List;

public interface commentRepository extends JpaRepository<comment, String > {
    List<comment> findByPostId(String postId);
}
