package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Model.WatchList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WatchListService{
    WatchList addCourseToWatchList(String userId, String courseId);
    List<WatchList> getWatchListByUserId(String userId);
}
