package com.bridgelabz.addressbook_application.controller;

import com.bridgelabz.addressbook_application.dto.UserDto;
import com.bridgelabz.addressbook_application.entities.Users;
import com.bridgelabz.addressbook_application.services.IEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    IEService userService;

    //Post-created User
    @PostMapping("/post")
    public String createUser(@RequestBody Users users){
        userService.CreateUser(users);
        return "Contact is added";
    }
    //PUT-Update & Edit
    @PutMapping("/Put/{userID}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userID") Integer userID){
        UserDto updateUser=this.userService.UpdateUser(userDto,userID);
        return  ResponseEntity.ok(updateUser);
    }
    //Delete
    @DeleteMapping("/{userID}")
    public String deleteUser(@PathVariable("userID") Integer userID){
        return userService.deletesUser(userID);
    }

    //GetAll
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUser(){
         return ResponseEntity.ok(this.userService.getAllUsers());
    }
    //Get
    @GetMapping("/get/{userID}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userID") Integer userID){

        return ResponseEntity.ok(this.userService.getUserById(userID));
    }
}
