package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Dto.FrontendCourseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FrontendCourseService {
    List<FrontendCourseDto> getAllFrontendCourses();
}
