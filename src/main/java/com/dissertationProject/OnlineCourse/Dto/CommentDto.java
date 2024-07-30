package com.dissertationProject.OnlineCourse.Dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    @Id
    private String id;
    private String userId;
    private String courseId;
    private String content;
    private Date createdDate;
    private String userName;

}
