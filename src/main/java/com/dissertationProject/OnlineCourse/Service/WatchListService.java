package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Model.WatchList;
import org.springframework.stereotype.Service;

@Service
public interface WatchListService{
    WatchList addCourseToWatchList(String userId, String courseId);

}
