package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Dto.WatchListDto;
import com.dissertationProject.OnlineCourse.Model.WatchList;
import com.dissertationProject.OnlineCourse.Service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/C")
public class WatchListController {
    @Autowired
    private WatchListService watchListService;

    @PostMapping("/{userId}/addCourse")
    public ResponseEntity<WatchList> addCourseToWatchList(
            @PathVariable String userId,  @RequestBody Map<String, String> requestBody){
        String courseId = requestBody.get("courseId");
        WatchList updatedWatchList = watchListService.addCourseToWatchList(userId, courseId);
        return new ResponseEntity<>(updatedWatchList, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<WatchListDto> getWatchListByUserId(@PathVariable String userId) {
        WatchListDto watchLists = watchListService.getWatchListByUserId(userId);
        return new ResponseEntity<>(watchLists, HttpStatus.OK);
    }


    @DeleteMapping("/removeCourse")
    public ResponseEntity<WatchList> removeCourseFromWatchList(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("userId");
        String courseId = requestBody.get("courseId");
        WatchList updatedWatchList = watchListService.removeCourseFromWatchList(userId, courseId);
        return new ResponseEntity<>(updatedWatchList, HttpStatus.OK);
    }
}
