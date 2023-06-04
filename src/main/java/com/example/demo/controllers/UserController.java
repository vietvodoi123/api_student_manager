package com.example.demo.controllers;

import com.example.demo.model.ResponeObject;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/Users")
public class UserController {
    @Autowired
    private UserRepository repository;

//    get all user
    @GetMapping("")
    List<User> getAllUsers(){
        return repository.findAll();
    }

    @PostMapping("/insert")
    ResponseEntity<ResponeObject> insertUser(@RequestBody User newUser){
        List<User> foundUser = repository.findByUsername((newUser.getUsername().trim()));

        if(foundUser.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponeObject("false","username already taken","")
            );
        }
        else {
            repository.save(newUser);
            System.out.println(newUser);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","insert a student sucsessfully",newUser)
            );
        }
    }

    @PostMapping("/login")
    ResponseEntity<ResponeObject> loginUser(@RequestBody User userLogin){
        List<User> foundUser = repository.findByUsername(userLogin.getUsername().trim());
       for (User x : foundUser){
           if(x.equals(userLogin)){
               return ResponseEntity.status(HttpStatus.OK).body(
                       new ResponeObject("ok","login sucsesfull","")
               );
           }
       }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("false","username or password is wrong","")
        );
    }

    @PutMapping("/changePassword")
    ResponseEntity<ResponeObject> updateUser(@RequestBody User userChange){
        List<User> foundUser = (List<User>) repository.findByUsername(userChange.getUsername());
        if(foundUser.size()>0){
            foundUser.stream().map(user -> {
                user.setPassword(userChange.getPassword());
                return  repository.save(user);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","change password sucsessfuly",userChange)
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("false","username or password is wrong","")
            );
        }
    }
}
