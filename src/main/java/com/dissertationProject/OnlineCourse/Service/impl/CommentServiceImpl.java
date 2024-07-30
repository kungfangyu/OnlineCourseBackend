package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.CommentDto;
import com.dissertationProject.OnlineCourse.Model.Comment;
import com.dissertationProject.OnlineCourse.Model.Course;
import com.dissertationProject.OnlineCourse.Model.User;
import com.dissertationProject.OnlineCourse.Repository.CommentRepo;
import com.dissertationProject.OnlineCourse.Repository.CourseRepo;
import com.dissertationProject.OnlineCourse.Repository.UserRepo;
import com.dissertationProject.OnlineCourse.Service.CommentService;
import com.dissertationProject.OnlineCourse.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public CommentDto addComment(String userId, String courseId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setCourseId(courseId);
        comment.setContent(content);
        comment.setCreatedDate(new Date());

        Comment savedComment = commentRepo.save(comment);

        Course course = courseRepo.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course not found"));
        course.getComments().add(savedComment);
        courseRepo.save(course);

        return convertToDto(savedComment);
    }

    @Override
    public List<CommentDto> getCommentsByCourseId(String courseId) {
        List<Comment> comments = commentRepo.findByCourseId(courseId);
        return comments.stream().map(this::convertToDto).toList();
    }

    private CommentDto convertToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setUserId(comment.getUserId());
        dto.setCourseId(comment.getCourseId());
        dto.setContent(comment.getContent());
        dto.setCreatedDate(comment.getCreatedDate());
        //Get user name from user id
         User user = userRepo.findById(comment.getUserId()).orElse(null);
         if (user != null) {
             dto.setUserName(user.getLastName());
         }
        return dto;
    }

}
