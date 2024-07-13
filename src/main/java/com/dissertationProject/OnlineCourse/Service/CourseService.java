package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<CourseDto> getAllCourses();
    List<CourseDto> getCoursesByCategory(String category);
}
