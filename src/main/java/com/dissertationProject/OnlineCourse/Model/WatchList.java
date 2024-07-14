package com.dissertationProject.OnlineCourse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "WatchList")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchList {
    @Id
    private String userId;
    private List<WatchListItem> items = new ArrayList<>(); // WatchListItem is a class that contains the details of a course
}
