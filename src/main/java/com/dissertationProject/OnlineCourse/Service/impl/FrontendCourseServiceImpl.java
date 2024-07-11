package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Model.Courses;
import com.dissertationProject.OnlineCourse.Repository.FrontendRepo;
import com.dissertationProject.OnlineCourse.Service.FrontendCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FrontendCourseServiceImpl implements FrontendCourseService {
    @Autowired
    private FrontendRepo frontendRepo;

    @Override
    public List<CourseDto> getAllFrontendCourses() {
        List<Courses> courses = frontendRepo.findAll();
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private CourseDto convertToDto(Courses course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setInstructor(course.getInstructor());
        dto.setInstructorInfo(course.getInstructorInfo());
        dto.setImageUrl(course.getImageUrl());
        dto.setLanguage(course.getLanguage());
        dto.setPostedDate(course.getPostedDate());

        if (course.getVideos() != null) {
            dto.getVideoList().addAll(course.getVideos());
        }

        return dto;
    }
}
