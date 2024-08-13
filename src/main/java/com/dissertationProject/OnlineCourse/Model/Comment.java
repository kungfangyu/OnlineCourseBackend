package com.dissertationProject.OnlineCourse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// This class is a model for the Comment entity. It contains the attributes of the Comment entity.
@Document(collection = "Comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    private String courseId;
    private String userId;
    private String content;
    private LocalDateTime postedDate;
    private String userName;
}
