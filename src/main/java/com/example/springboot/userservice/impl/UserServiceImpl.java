package com.example.springboot.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.springboot.shared.Utils;
import com.example.springboot.ui.model.request.UserDetailsRequestModel;
import com.example.springboot.ui.model.response.UserRest;
import com.example.springboot.userservice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    Map<String,UserRest> users;
    Utils utils;

    public UserServiceImpl(){}

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        // TODO Auto-generated method stub
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = utils.generateUserID();
        returnValue.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
    
    
    
}
