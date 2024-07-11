package com.dissertationProject.OnlineCourse.Dto;

import com.dissertationProject.OnlineCourse.Model.Courses;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    private String id;
    private String courseName;
    private String description;
    private String instructor;
    private String instructorInfo;

    private String imageUrl;
    private String language;
    private String postedDate;
    private List<Courses.Video> videoList = new ArrayList<>();

}
