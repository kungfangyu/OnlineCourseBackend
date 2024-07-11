package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.FrontendCourse;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FrontendRepo extends MongoRepository<FrontendCourse, String> {
}
