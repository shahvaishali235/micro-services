package com.example.UserMicroService.service;

import com.example.UserMicroService.dao.UserDao;
import com.example.UserMicroService.pojo.Rating;
import com.example.UserMicroService.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    RestTemplate restTemplate;

    public User saveUser(User user) {
        User user1 = userDao.save(user);
        System.out.println(user1);
        return user1;
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> findUser(String userId) {
        //fetch user from user_db
        Optional<User> user = userDao.findById(userId);

        if (user.isPresent()) {
            // calling another service i.e. Rating service
            Rating rating = restTemplate.getForObject("http://RATING-MICROSERVICE/rating/" + userId, Rating.class);
            user.get().setRating(rating);
            return user;
        } else {
            return null;
        }
    }
}
