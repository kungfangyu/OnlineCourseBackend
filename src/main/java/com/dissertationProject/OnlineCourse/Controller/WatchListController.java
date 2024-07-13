package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Model.WatchList;
import com.dissertationProject.OnlineCourse.Service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watchlist")
public class WatchListController {
    @Autowired
    private WatchListService watchListService;

    @PostMapping("/{userId}/addCourse")
    public ResponseEntity<WatchList> addCourseToWatchList(
            @PathVariable String userId, String courseId, @RequestParam String category){
        WatchList updatedWatchList = watchListService.addCourseToWatchList(userId, courseId);
        return new ResponseEntity<>(updatedWatchList, HttpStatus.OK);
    }
}
