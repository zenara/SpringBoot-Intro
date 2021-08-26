package com.example.springboot.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.example.springboot.ui.model.request.UserDetailsRequestModel;
import com.example.springboot.ui.model.response.UserRest;
import com.example.springboot.userservice.UserService;

public class UserServiceImpl implements UserService{

    Map<String,UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        // TODO Auto-generated method stub
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
    
    
    
}
