package com.example.UserMicroService.controller;


import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping()
    public List<String> getManager() {
        return Arrays.asList("vishal", "shah", "abc", "xyz", "vaishali");
    }

}
