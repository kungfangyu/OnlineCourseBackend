package com.dissertationProject.OnlineCourse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
// This class is a model for the WatchListItem entity. It contains the attributes of the WatchListItem entity.
public class WatchListItem {
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
}
