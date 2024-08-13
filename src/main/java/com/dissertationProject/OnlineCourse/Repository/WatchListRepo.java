package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.WatchList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

// This interface extends the MongoRepository interface. It is used to perform CRUD operations on the WatchList entity.
public interface WatchListRepo extends MongoRepository<WatchList, String> {
    List<WatchList> findByUserId(String userId);

}
