package com.dissertationProject.OnlineCourse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    private String videoId;
    private String videoTitle;
    private String videoDescription;
    private String videoUrl;
    private String duration;
    private Integer order;
    private String resourceUrl;
}