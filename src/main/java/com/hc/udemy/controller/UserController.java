package com.hc.udemy.controller;

import com.hc.udemy.entity.User;
import com.hc.udemy.service.UserService;
import com.hc.udemy.util.ResponseBody;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/fb/user")
public class UserController{
     UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    //save user
    @PostMapping
    public ResponseEntity<ResponseBody> saveUser(@Valid @RequestBody User user){

        User user1 = userService.saveUser(user);

        URI path= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getUserId()).toUri();
        ResponseEntity<Object> build = ResponseEntity.created(path).build();
        ResponseBody responseBody=new ResponseBody(path.toString(), user1);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public EntityModel<User> fetchById(@PathVariable("id") Integer userId){
        User user = userService.fetchById(userId);
        EntityModel<User> model=EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder=linkTo(methodOn(this.getClass()).getAllUsers());
        model.add(linkBuilder.withRel("all_Users"));

        return model;
    }

    @GetMapping
    public User fetchByFirstName(@RequestParam String firstName){
        return userService.fetchByName(firstName);
    }

    @DeleteMapping
    public String deleteById(@RequestParam Integer userId){
        return userService.deleteById(userId);
    }
}
