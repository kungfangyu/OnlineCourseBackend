package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


// This interface extends the MongoRepository interface. It is used to perform CRUD operations on the Comment entity.
public interface CommentRepo extends MongoRepository<Comment, String> {
    List<Comment> findByCourseId(String courseId);
}
