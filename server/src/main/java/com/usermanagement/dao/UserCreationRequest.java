package com.usermanagement.dao;

import lombok.Getter;

@Getter
public class UserCreationRequest {

    private String name;
    private String email;
    private String type;
    private String address;
    private String dob;
    private String password;

}
