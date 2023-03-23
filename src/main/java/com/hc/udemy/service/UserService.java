package com.hc.udemy.service;

import com.hc.udemy.entity.User;
import com.hc.udemy.exception.UserNotFoundException;
import com.hc.udemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Add User
    public User saveUser(User user){
        return userRepository.save(user);
    }

    //retrieve by UserId
    public User fetchById(Integer userId){
        Optional<User> user = userRepository.findById(userId);
        System.out.println(user);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserNotFoundException("User is NOT_FOUND for userId "+userId);
        }
    }

    //fetch by name
    public User fetchByName(String firstName){
        User byFirstName = userRepository.findByFirstName(firstName);
        return byFirstName;
    }

    //Delete by userId
    public String deleteById(Integer userId){
        Optional<User> byId = userRepository.findById(userId);
        if(byId.isPresent()){
            userRepository.deleteById(userId);
            return "UserId of "+userId+" Deleted Successfully..!";
        }else{
            throw new UserNotFoundException("User is NOT_FOUND for userId "+userId);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
