package com.example.RatingMicroService.dao;

import com.example.RatingMicroService.pojo.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingDao extends JpaRepository<Rating, String> {

    Optional<Rating> findByUserId(String userId);
}
