package com.example.UserMicroService.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class Rating {

    private String rating_id;
    private String user_id;
    private int rating;
    private String feedback;

}
