package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CourseDto>> getAllCoursesByUserId(@PathVariable String userId, @RequestParam String category) {
        List<CourseDto> courses = courseService.getAllCoursesByUserId(userId, category);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    /*
     * Get courses by category
     */
    @GetMapping("/category")
    public ResponseEntity<List<CourseDto>> getCoursesByCategory(@RequestParam String category) {
        List<CourseDto> courses = courseService.getCoursesByCategory(category);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    /*
     * Get single course by courseId
     */

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String courseId) {
        try {
            CourseDto course = courseService.getCourseById(courseId);
            if (course != null) {
                return new ResponseEntity<>(course, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.err.println("Error fetching course by ID: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
