package com.dissertationProject.OnlineCourse.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

/*
UserDto

Defines fields/data that will be transmitted to/from the API client when requesting/sending User data.

Original Author: Fangyu Kung 07/07/2024
 */

public class UserDto {
    @NotEmpty(message = "First name is mandatory")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory")
    private String lastName;

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    private String password;
}

