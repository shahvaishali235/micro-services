package com.example.UserMicroService.controller;

import com.example.UserMicroService.pojo.User;
import com.example.UserMicroService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    @GetMapping("{id}")
    public Map<String, Object> findById(@PathVariable String id) {
        Optional<User> user = userService.findUser(id);
        if (user.isPresent()) {
            return Map.of("message", "User found", "data", user.get());
        } else {
            return Map.of("message", "User not found", "data", null);
        }
    }
}
