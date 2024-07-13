package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Model.Course;
import com.dissertationProject.OnlineCourse.Repository.CourseRepo;
import com.dissertationProject.OnlineCourse.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByCategory(String category) {
        List<Course> courses = courseRepo.findByCategory(category);
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private CourseDto convertToDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setCourseId(course.getCourseId());
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setInstructor(course.getInstructor());
        dto.setInstructorInfo(course.getInstructorInfo());
        dto.setImageUrl(course.getImageUrl());
        dto.setLanguage(course.getLanguage());
        dto.setPostedDate(course.getPostedDate());
        dto.setIsAdd(course.getIsAdd());
        dto.setCategory(course.getCategory());
        if (course.getVideos() != null) {
            dto.getVideos().addAll(course.getVideos());
        }
        return dto;
    }
}
