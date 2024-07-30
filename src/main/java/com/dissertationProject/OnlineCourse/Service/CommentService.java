package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Dto.CommentDto;
import com.dissertationProject.OnlineCourse.Model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    CommentDto addComment(String userId, String courseId, String content);
    List<CommentDto> getCommentsByCourseId(String courseId);
}
