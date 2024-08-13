package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.CourseDto;
import com.dissertationProject.OnlineCourse.Dto.WatchListDto;
import com.dissertationProject.OnlineCourse.Dto.WatchListItemDto;
import com.dissertationProject.OnlineCourse.Model.Course;
import com.dissertationProject.OnlineCourse.Model.WatchList;
import com.dissertationProject.OnlineCourse.Model.WatchListItem;
import com.dissertationProject.OnlineCourse.Repository.CourseRepo;
import com.dissertationProject.OnlineCourse.Repository.WatchListRepo;
import com.dissertationProject.OnlineCourse.Service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WatchListServiceImpl implements WatchListService {
    @Autowired
    private WatchListRepo watchListRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public WatchList addCourseToWatchList(String userId, String courseId) {
        Optional<Course> courseOptional = courseRepo.findById(courseId);
        if (!courseOptional.isPresent()) {
            System.out.println("Course not found for ID: " + courseId);
            throw new RuntimeException("Course not found");
        }
        Course course = courseOptional.get();
        CourseDto courseDto = convertToCourseDto(course);

        Optional<WatchList> watchListOptional = watchListRepo.findById(userId);
        WatchList watchList;
        if (watchListOptional.isPresent()) {
            watchList = watchListOptional.get();
        } else {
            watchList = new WatchList();
            watchList.setUserId(userId);
            watchList.setItems(new ArrayList<>());
        }

        for (WatchListItem item : watchList.getItems()) {
            if (item.getCourseId().equals(courseDto.getCourseId())) {
                throw new IllegalArgumentException("Course already in watchlist");
            }
        }



        WatchListItem watchListItem = new WatchListItem();

        watchListItem.setCourseId(courseDto.getCourseId());
        watchListItem.setCourseName(courseDto.getCourseName());
        watchListItem.setDescription(courseDto.getDescription());
        watchListItem.setInstructor(courseDto.getInstructor());
        watchListItem.setInstructorInfo(courseDto.getInstructorInfo());
        watchListItem.setCategory(courseDto.getCategory());
        watchListItem.setImageUrl(courseDto.getImageUrl());
        watchListItem.setLanguage(courseDto.getLanguage());
        watchListItem.setPostedDate(courseDto.getPostedDate());
        watchListItem.setIsAdd(true);
        watchListItem.setVideos(courseDto.getVideos());

        //Add to watchlist
        watchList.getItems().add(watchListItem);
        return watchListRepo.save(watchList);
    }


    @Override
    public WatchListDto getWatchListByUserId(String userId) {
        Optional<WatchList> watchListOptional = watchListRepo.findById(userId);
        if(watchListOptional.isPresent()){
            WatchList watchList = watchListOptional.get();
            if(watchList.getItems() == null){
                watchList.setItems(new ArrayList<>());
            }
            return convertToWatchListDto(watchList);
        }else {
            WatchListDto emptyWatchListDto = new WatchListDto();
            emptyWatchListDto.setUserId(userId);
            emptyWatchListDto.setItems(new ArrayList<>());
            return emptyWatchListDto;
        }
    }

    @Override
    public List<CourseDto> getAllCoursesByUserId(String userId) {
        List<Course> courses = courseRepo.findAll();

        // 查找用户的 WatchList
        Optional<WatchList> watchListOptional = watchListRepo.findById(userId);
        WatchList watchList = watchListOptional.orElseGet(() -> {
            WatchList newWatchList = new WatchList();
            newWatchList.setUserId(userId);
            newWatchList.setItems(new ArrayList<>());
            return newWatchList;
        });

        if (watchList.getItems() == null) {
            watchList.setItems(new ArrayList<>());
        }

        // 遍历课程并设置 isAdd 字段
        return courses.stream().map(course -> {
            CourseDto dto = convertToCourseDto(course);
            boolean isAdded = watchList.getItems().stream()
                    .anyMatch(watchListItem -> watchListItem.getCourseId().equals(course.getCourseId()));
            dto.setIsAdd(isAdded);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public WatchList removeCourseFromWatchList(String userId, String courseId) {
        Optional<WatchList> watchListOptional = watchListRepo.findById(userId);
        if (!watchListOptional.isPresent()) {
            throw new RuntimeException("WatchList not found for user:" + userId);
        }
        WatchList watchList = watchListOptional.get();
        List<WatchListItem> items = watchList.getItems();
        items.removeIf(item -> item.getCourseId().equals(courseId));
        watchList.setItems(items);
        return watchListRepo.save(watchList);
    }


    private WatchListDto convertToWatchListDto(WatchList watchList) {
        WatchListDto dto = new WatchListDto();
        dto.setUserId(watchList.getUserId());
        dto.setItems(watchList.getItems().stream().map(this::convertToWatchListItemDto).collect(Collectors.toList()));
        return dto;
    }

    private WatchListItemDto convertToWatchListItemDto(WatchListItem item) {
        WatchListItemDto dto = new WatchListItemDto();
        dto.setCourseId(item.getCourseId());
        dto.setCourseName(item.getCourseName());
        dto.setDescription(item.getDescription());
        dto.setInstructor(item.getInstructor());
        dto.setInstructorInfo(item.getInstructorInfo());
        dto.setCategory(item.getCategory());
        dto.setImageUrl(item.getImageUrl());
        dto.setLanguage(item.getLanguage());
        dto.setPostedDate(item.getPostedDate());
        dto.setIsAdd(item.getIsAdd());
        dto.setVideos(item.getVideos());
        return dto;
    }

    private CourseDto convertToCourseDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setCourseId(course.getCourseId());
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setInstructor(course.getInstructor());
        dto.setInstructorInfo(course.getInstructorInfo());
        dto.setImageUrl(course.getImageUrl());
        dto.setLanguage(course.getLanguage());
        dto.setPostedDate(course.getPostedDate());
        dto.setVideos(course.getVideos());
        dto.setCategory(course.getCategory());
        return dto;
    }

}
