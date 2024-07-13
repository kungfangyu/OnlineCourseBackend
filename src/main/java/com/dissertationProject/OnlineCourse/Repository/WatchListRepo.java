package com.dissertationProject.OnlineCourse.Repository;

import com.dissertationProject.OnlineCourse.Model.WatchList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface WatchListRepo extends MongoRepository<WatchList, String> {
    List<WatchList> findByUserId(String userId);

}
