package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Dto.BackendCourseDto;
import com.dissertationProject.OnlineCourse.Dto.FrontendCourseDto;
import com.dissertationProject.OnlineCourse.Service.BackendCourseService;
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
    @Autowired
    private BackendCourseService backendCourseService;

    @GetMapping("/frontend")
    public ResponseEntity<List<FrontendCourseDto>> getAllFrontendCourses() {
        List<FrontendCourseDto> courses = frontendCourseService.getAllFrontendCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/backend")
    public ResponseEntity<List<BackendCourseDto>> getAllBackendCourses() {
        List<BackendCourseDto> courses = backendCourseService.getAllBackendCourses();
        return ResponseEntity.ok(courses);
    }

}
