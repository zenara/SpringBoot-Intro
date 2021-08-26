package com.example.springboot.userservice;

import com.example.springboot.ui.model.request.UserDetailsRequestModel;
import com.example.springboot.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
