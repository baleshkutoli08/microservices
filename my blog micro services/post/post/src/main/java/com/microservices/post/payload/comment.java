package com.microservices.post.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class comment {
    private String commentid;
    private String name;
    private String email;
    private String body;
    private String postId;

}
