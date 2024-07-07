package com.dissertationProject.OnlineCourse.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor

/*
UserDto

Defines fields/data that will be transmitted to/from the API client when requesting/sending User data.

Original Author: Fangyu Kung 07/07/2024
 */

public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

