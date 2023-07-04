package com.usermanagement.service;

import com.usermanagement.dao.UserCreationRequest;
import com.usermanagement.dao.UserLoginRequest;
import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    User createUser(UserCreationRequest userCreationRequest);
    UserDto getUserByEmail(String email);
    User updateUser(String email);
    User login(UserLoginRequest userLoginRequest);

}
