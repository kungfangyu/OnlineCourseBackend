package com.dissertationProject.OnlineCourse.Service.impl;

import com.dissertationProject.OnlineCourse.Dto.UserDto;
import com.dissertationProject.OnlineCourse.Dto.UserLoginDto;
import com.dissertationProject.OnlineCourse.Model.User;
import com.dissertationProject.OnlineCourse.Repository.UserRepo;
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
        return null;
    }

    public String loginUser(String email, String password) throws Exception {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if(!userOpt.isPresent()) {
            throw new Exception("User not found");
        }
        User user = userOpt.get();
        if(!user.getPassword().matches(user.getPassword())) {
            throw new Exception("Invalid password");
        }
        //Generate JWT token
        String token = generateToken(user);
        return token;
    }

    private String generateToken(User user) {
        // Generate JWT token using a library like jjwt (not shown)
        return "generated-jwt-token";
    }
}
