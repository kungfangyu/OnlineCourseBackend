package com.dissertationProject.OnlineCourse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Course")
@Data
@NoArgsConstructor
@AllArgsConstructor

// This class is a model for the Course entity. It contains the attributes of the Course entity.
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String description;
    private String instructor;
    private String instructorInfo;
    private String category;
    private String imageUrl;
    private String language;
    private String postedDate;
    private Boolean isAdd;

    private List<Video> videos;
    private List<Comment> comments;
}
