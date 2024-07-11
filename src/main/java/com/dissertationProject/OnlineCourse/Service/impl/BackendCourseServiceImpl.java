package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.BackendCourseDto;
import com.dissertationProject.OnlineCourse.Model.BackendCourse;
import com.dissertationProject.OnlineCourse.Repository.BackendRepo;
import com.dissertationProject.OnlineCourse.Service.BackendCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BackendCourseServiceImpl implements BackendCourseService {
    @Autowired
    private BackendRepo backendRepo;

    @Override
    public List<BackendCourseDto> getAllBackendCourses() {
        List<BackendCourse> courses = backendRepo.findAll();
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private BackendCourseDto convertToDto(BackendCourse course) {
        BackendCourseDto dto = new BackendCourseDto();
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
