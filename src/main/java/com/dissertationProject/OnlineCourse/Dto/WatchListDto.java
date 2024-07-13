package com.dissertationProject.OnlineCourse.Dto;

import com.dissertationProject.OnlineCourse.Model.Video;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WatchListDto {
    private String courseId;
    private String userId;
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
}
