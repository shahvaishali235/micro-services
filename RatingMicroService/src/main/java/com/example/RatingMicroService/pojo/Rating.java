package com.example.RatingMicroService.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity

public class Rating {

    public String getRating_id() {
        return rating_id;
    }

    public void setRating_id(String rating_id) {
        this.rating_id = rating_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rating_id;
    private String user_id;
    private int rating;
    private String feedback;

    @Override
    public String toString() {
        return rating_id + "\t" + user_id + "\t" + rating + "\t" + feedback;
    }
}
