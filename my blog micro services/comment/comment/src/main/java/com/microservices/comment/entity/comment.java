package com.microservices.comment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
@Table(name = "comment")
public class comment {
    @Id
    private  String Id;
    private String name;
    private String email;
    private String body;
    private String postId;

}
