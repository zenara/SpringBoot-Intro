package com.example.springboot.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import com.example.springboot.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.springboot.ui.model.request.UserDetailsRequestModel;
import com.example.springboot.ui.model.response.UserRest;
import com.example.springboot.userservice.impl.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") // http:localhost:8080/users
public class UserController {

    Map<String,UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(value = "sort", required =  false) String sort)
    {
        return "get user was called with page = " + page + " limit = " + limit + " sort = " + sort;
    }

    @GetMapping(path="/{userId}", produces = { 
        MediaType.APPLICATION_XML_VALUE, 
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId)
    {
        // if(true) throw new UserServiceException("A User Service Exception is thrown");

        if(users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(produces = { 
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    },
    consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnValue = new UserServiceImpl().createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path="/{userId}", produces = { 
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    },
    consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel uModel)
    {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(uModel.getFirstName());
        storedUserDetails.setLastName(uModel.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId)
    {
        users.remove(userId);

        return ResponseEntity.noContent().build();
    }

}