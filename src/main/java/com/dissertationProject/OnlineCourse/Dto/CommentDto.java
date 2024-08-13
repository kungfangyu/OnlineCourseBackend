package com.dissertationProject.OnlineCourse.Dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    @Id
    private String courseId;
    private String userId;
    private String content;
    private String userName;
    private LocalDateTime postedDate = LocalDateTime.now();

}
