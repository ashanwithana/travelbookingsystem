package com.usermanagement.service;

import com.usermanagement.dao.UserCreationRequest;
import com.usermanagement.dao.UserLoginRequest;
import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;
import com.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public User createUser(UserCreationRequest userCreationRequest) {
        return this.userRepository.save(User.builder()
                        .name(userCreationRequest.getName())
                        .address(userCreationRequest.getAddress())
                        .email(userCreationRequest.getEmail())
                        .dob(userCreationRequest.getDob())
                        .type(userCreationRequest.getType())
                        .password(userCreationRequest.getPassword())
                        .createdDate(LocalDateTime.now())
                        .active(Boolean.TRUE)
                        .build());
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        if(user != null){
            return UserDto.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .dob(user.getDob())
                    .type(user.getType())
                    .address(user.getAddress())
                    .build();
        }
        return null;
    }

    @Override
    public User updateUser(String email) {
        User user = this.userRepository.findByEmail(email);
        if(user != null){
            user.setActive(!user.getActive());
            this.userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = this.userRepository.findByEmail(userLoginRequest.getEmail());
        if(user != null){
            if(user.getPassword().equals(userLoginRequest.getPassword())){
                return user;
            }else{
                return null;
            }
        }
            return null;
    }

}
