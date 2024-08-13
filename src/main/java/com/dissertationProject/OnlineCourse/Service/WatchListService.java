package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Dto.WatchListDto;
import com.dissertationProject.OnlineCourse.Model.WatchList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WatchListService{
    WatchList addCourseToWatchList(String userId, String courseId);
    WatchListDto getWatchListByUserId(String userId);

    List<CourseDto> getAllCoursesByUserId(String userId);

    WatchList removeCourseFromWatchList(String userId, String courseId);

}
