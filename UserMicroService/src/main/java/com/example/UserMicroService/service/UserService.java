package com.example.UserMicroService.service;

import com.example.UserMicroService.dao.UserDao;
import com.example.UserMicroService.pojo.Rating;
import com.example.UserMicroService.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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

    public Optional<User> findUser(String id) {
        //fetch user from user_db
        Optional<User> user = userDao.findById(id);
        System.out.println("user from user_db : " + user.get());
        Rating rating = restTemplate.getForObject("http://localhost:8082/rating/" + id, Rating.class);
        System.out.println("rating from rating_db : " + rating);
        user.get().setRating(rating);
        System.out.println("final user : " + user.get());
        if (user.isPresent()) {
            return user;
        } else {
            return null;
        }
    }
}
