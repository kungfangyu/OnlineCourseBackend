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
public class BackendCourseDto {
    private String id;
    private String courseName;
    private String description;
    private String instructor;
    private String instructorInfo;
    private String imageUrl;
    private String language;
    private String postedDate;
    private List<Video> videoList = new ArrayList<>();
}
