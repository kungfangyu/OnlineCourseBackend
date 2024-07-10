package com.dissertationProject.OnlineCourse.Service;

import com.dissertationProject.OnlineCourse.Dto.UserDto;
import com.dissertationProject.OnlineCourse.Dto.UserLoginDto;
import com.dissertationProject.OnlineCourse.Model.User;
import com.dissertationProject.OnlineCourse.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User registerUser(UserDto userDto) throws Exception;
    String loginUser(UserLoginDto userLoginDto) throws Exception;

}
