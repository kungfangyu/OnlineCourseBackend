package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.WatchList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WatchListRepo extends MongoRepository<WatchList, String> {
    Optional<WatchList> findByUserId(String userId);

}
