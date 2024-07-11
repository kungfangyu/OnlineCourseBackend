package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.Courses;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FrontendRepo extends MongoRepository<Courses, String> {
}
