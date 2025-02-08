package com.example.RatingMicroService.service;

import com.example.RatingMicroService.dao.RatingDao;
import com.example.RatingMicroService.pojo.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingDao ratingDao;
    public Rating saveRating(Rating rating) {
        return ratingDao.save(rating);
    }

    public List<Rating> findAllUsers() {
        return ratingDao.findAll();
    }

    public Optional<Rating> findRating(String rating_id) {
        Optional<Rating> rating = ratingDao.findById(rating_id);
        System.out.println(rating.get());
        if (rating.isPresent()) {
            return rating;
        } else {
            return null;
        }
    }

    public Optional<Rating> findByUserId(String userId) {
        return ratingDao.findByUserId(userId);
    }
}
