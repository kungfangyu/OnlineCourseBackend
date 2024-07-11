package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Service.FrontendCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private FrontendCourseService frontendCourseService;

    @GetMapping("/frontend")
    public ResponseEntity<List<CourseDto>> getAllFrontendCourses() {
        List<CourseDto> courses = frontendCourseService.getAllFrontendCourses();
        return ResponseEntity.ok(courses);
    }

}
