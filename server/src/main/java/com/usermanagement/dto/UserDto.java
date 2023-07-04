package com.usermanagement.dto;

import com.usermanagement.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UserDto {

    private String name;
    private String email;
    private String type;
    private String address;
    private String dob;
    private  Boolean active;
    public UserDto(User user){

        this.name = user.getName();
        this.email = user.getEmail();
        this.type = user.getType();
        this.address = user.getAddress();
        this.dob = user.getDob();
        this.active = user.getActive();

    }


}
