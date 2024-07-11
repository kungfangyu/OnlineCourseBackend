package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.BackendCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BackendRepo extends MongoRepository<BackendCourse, String> {
}
