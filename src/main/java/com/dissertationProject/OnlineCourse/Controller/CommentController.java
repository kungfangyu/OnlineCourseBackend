package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Dto.CommentDto;
import com.dissertationProject.OnlineCourse.Model.Comment;
import com.dissertationProject.OnlineCourse.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{courseId}/addComment")
    public ResponseEntity<CommentDto> addComment(@RequestParam String userId, @RequestParam String courseId, @RequestParam String content) {
        CommentDto newComment = commentService.addComment(userId, courseId, content);
        return new ResponseEntity<>(newComment, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<List<CommentDto>> getCommentsByCourseId(@PathVariable String courseId) {
        List<CommentDto> comments = commentService.getCommentsByCourseId(courseId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

}
