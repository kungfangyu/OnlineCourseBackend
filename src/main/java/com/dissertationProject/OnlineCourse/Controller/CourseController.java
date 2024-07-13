package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /*
    * Get all courses without userId
     */
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    /*
    * Get all courses by userId
     */

    @GetMapping("/{userId}")
    public ResponseEntity<List<CourseDto>> getAllCoursesByUserId(@RequestParam String userId) {
        List<CourseDto> courses = courseService.getAllCoursesByUserId(userId);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CourseDto>> getCoursesByCategory(@RequestParam String category) {
        List<CourseDto> courses = courseService.getCoursesByCategory(category);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
