package com.dissertationProject.OnlineCourse.Controller;

import com.dissertationProject.OnlineCourse.Model.User;
import com.dissertationProject.OnlineCourse.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userRepo.save(user);
    }
}

