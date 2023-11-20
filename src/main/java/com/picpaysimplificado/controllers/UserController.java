package com.picpaysimplificado.controllers;

import com.picpaysimplificado.dto.UserDto;
import com.picpaysimplificado.model.user.User;
import com.picpaysimplificado.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto dto){
        User newUser = service.createUser(dto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.service.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
