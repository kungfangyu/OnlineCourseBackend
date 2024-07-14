package com.dissertationProject.OnlineCourse.Dto;

import com.dissertationProject.OnlineCourse.Model.Video;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WatchListDto {
    private String userId;
    private List<WatchListItemDto> items;
}
