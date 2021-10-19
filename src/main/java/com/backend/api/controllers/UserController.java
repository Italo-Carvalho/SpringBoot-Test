package com.backend.api.controllers;

import com.backend.api.Model.User;
import com.backend.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        Optional<User> userFind = this.userRepository.findById(id);
        return userFind.orElse(null);
    }

    @PostMapping("/")
    public User create(@RequestBody User user){
        return this.userRepository.save(user);

    };

    @GetMapping("/list")
    public List<User> list(){
        return this.userRepository.findAll();
    };

    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id){
        return this.userRepository.findByIdGreaterThan(id);
    };

    @GetMapping("/findByName/{name}")
    public List<User> getByName(@PathVariable("name") String name){
        return this.userRepository.findByNameIgnoreCase(name);
    };

}
