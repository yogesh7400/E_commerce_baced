package com.abm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.User;
import com.abm.exception.UserException;
import com.abm.repo.UserRepository;
import com.abm.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() throws UserException {
        return userRepository.findAll();
    }
}
