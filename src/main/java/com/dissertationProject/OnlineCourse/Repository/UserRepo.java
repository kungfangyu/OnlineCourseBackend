package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

// This interface extends the MongoRepository interface. It is used to perform CRUD operations on the User entity.
public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
