package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.UserDto;
import com.dissertationProject.OnlineCourse.Dto.UserLoginDto;
import com.dissertationProject.OnlineCourse.Model.User;
import com.dissertationProject.OnlineCourse.Repository.UserRepo;
import com.dissertationProject.OnlineCourse.Security.JwtUtils;
import com.dissertationProject.OnlineCourse.Service.UserService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public User registerUser(UserDto userDto) throws Exception{
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return userRepo.save(user);
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) throws Exception {
        Optional<User> userOpt = userRepo.findByEmail(userLoginDto.getEmail());
        if(!userOpt.isPresent()) {
            throw new Exception("User not found");
        }
        User user = userOpt.get();
        if(!userLoginDto.getPassword().matches(user.getPassword())) {
            throw new Exception("Invalid password");
        }

        String token = JwtUtils.generateToken(user);
        return token;
    }

}
