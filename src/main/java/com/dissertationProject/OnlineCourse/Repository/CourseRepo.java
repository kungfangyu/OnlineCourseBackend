package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


// This interface extends the MongoRepository interface. It is used to perform CRUD operations on the Course entity.
public interface CourseRepo extends MongoRepository<Course, String> {
    List<Course> findByCategory(String category);
    Course findByCourseId(String courseId);

}
