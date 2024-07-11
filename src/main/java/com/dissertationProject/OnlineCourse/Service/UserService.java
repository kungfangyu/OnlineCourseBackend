package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Dto.UserDto;
import com.dissertationProject.OnlineCourse.Dto.UserLoginDto;
import com.dissertationProject.OnlineCourse.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserDto userDto) throws Exception;
    String loginUser(UserLoginDto userLoginDto) throws Exception;

}
