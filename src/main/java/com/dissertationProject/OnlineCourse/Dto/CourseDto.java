package com.dissertationProject.OnlineCourse.Dto;

import com.dissertationProject.OnlineCourse.Model.Video;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    private String courseId;
    private String courseName;
    private String description;
    private String instructor;
    private String instructorInfo;
    private String imageUrl;
    private String language;
    private String postedDate;
    private Boolean isAdd;
    private String category;
    private List<Video> videos = new ArrayList<>();
}