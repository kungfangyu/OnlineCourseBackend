package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Model.Course;
import com.dissertationProject.OnlineCourse.Model.WatchList;
import com.dissertationProject.OnlineCourse.Repository.CourseRepo;
import com.dissertationProject.OnlineCourse.Repository.WatchListRepo;
import com.dissertationProject.OnlineCourse.Service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchListServiceImpl implements WatchListService {
    @Autowired
    private WatchListRepo watchListRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public WatchList addCourseToWatchList(String userId, String courseId) {
        Optional<Course> courseOptional = courseRepo.findById(courseId);
        if (!courseOptional.isPresent()) {
            throw new RuntimeException("Course not found");
        }
        Course course = courseOptional.get();
        CourseDto courseDto = convertToCourseDto(course);
        return addCourseToUserWatchlist(userId, courseDto);
    }

    private WatchList addCourseToUserWatchlist(String userId, CourseDto courseDto) {

        WatchList watchlistItem = new WatchList();
        watchlistItem.setCourseId(courseDto.getCourseId());
        watchlistItem.setUserId(userId);
        watchlistItem.setCourseName(courseDto.getCourseName());
        watchlistItem.setDescription(courseDto.getDescription());
        watchlistItem.setInstructor(courseDto.getInstructor());
        watchlistItem.setInstructorInfo(courseDto.getInstructorInfo());
        watchlistItem.setCategory(courseDto.getCategory());
        watchlistItem.setImageUrl(courseDto.getImageUrl());
        watchlistItem.setLanguage(courseDto.getLanguage());
        watchlistItem.setPostedDate(courseDto.getPostedDate());
        watchlistItem.setIsAdd(true); // default is true
        watchlistItem.setVideos(courseDto.getVideos());

        return watchListRepo.save(watchlistItem);
    }

    @Override
    public List<WatchList> getWatchListByUserId(String userId) {
        return watchListRepo.findByUserId(userId);
    }

    private CourseDto convertToCourseDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setCourseId(course.getCourseId());
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setInstructor(course.getInstructor());
        dto.setInstructorInfo(course.getInstructorInfo());
        dto.setImageUrl(course.getImageUrl());
        dto.setLanguage(course.getLanguage());
        dto.setPostedDate(course.getPostedDate());
        dto.setVideos(course.getVideos());
        dto.setCategory(course.getCategory());
        return dto;
    }

}
