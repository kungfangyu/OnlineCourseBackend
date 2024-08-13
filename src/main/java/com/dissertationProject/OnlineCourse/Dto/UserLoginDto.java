package com.dissertationProject.OnlineCourse.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
public class UserLoginDto {
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email must not be empty")
    private String email;
    @NotEmpty(message = "Password must not be empty")
    private String password;
}
