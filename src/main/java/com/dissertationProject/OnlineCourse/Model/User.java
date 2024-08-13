package com.dissertationProject.OnlineCourse.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor

// This class is a model for the User entity. It contains the attributes of the User entity.
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

