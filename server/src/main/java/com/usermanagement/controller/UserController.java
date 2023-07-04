package com.usermanagement.controller;

import com.usermanagement.dao.UserCreationRequest;
import com.usermanagement.dao.UserLoginRequest;
import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PutMapping("update-user")
    public ResponseEntity<String> updateUser(
            @RequestParam("email") String email
    ){
        User user = this.userService.updateUser(email);
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully.");
    }

    @GetMapping("get-user")
    public ResponseEntity<Object> getUserByEmail(
            @RequestParam("email") String email
    ){
        UserDto userDto = this.userService.getUserByEmail(email);
        if(userDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @GetMapping("users")
    public List<UserDto> getUserByEmail(){
       return this.userService.getAllUsers();
    }

    @PostMapping("signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(
            @RequestBody UserCreationRequest userCreationRequest
    ){
        User user = this.userService.createUser(userCreationRequest);
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not created.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> login(
            @RequestBody UserLoginRequest userLoginRequest
    ){
        User user = this.userService.login(userLoginRequest);
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Or Password Wrong");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
