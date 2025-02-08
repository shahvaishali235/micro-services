package com.example.RatingMicroService.controller;


import com.example.RatingMicroService.pojo.Rating;
import com.example.RatingMicroService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating save(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @GetMapping
    public List<Rating> findAll() {
        return ratingService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public Map<String, Object> findById(@PathVariable String userId) {
        Optional<Rating> rating = ratingService.findByUserId(userId);
        if (rating.isPresent()) {
            return Map.of("message", "User found", "data", rating.get());
        } else {
            return Map.of("message", "User not found", "data", null);
        }
    }
}
