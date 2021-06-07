package com.example.rabbitspringsubmissionpublish;

import com.example.rabbitspringsubmissionpublish.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @GetMapping("/Mysql")
    public List<User> mysqltext(){
        return userRepository.findAll();
    }
}
