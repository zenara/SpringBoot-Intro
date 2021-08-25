package com.example.springboot.ui.controller;

import com.example.springboot.ui.model.request.UserDetailsRequestModel;
import com.example.springboot.ui.model.response.UserRest;

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
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Chathurika");
        returnValue.setLastName("Jayathilake");
        returnValue.setEmail("test@gmail.com");
        returnValue.setUserId(userId);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PostMapping(produces = { 
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    },
    consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails)
    {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setUserId(userDetails.getUserId());

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser()
    {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete user was called";
    }

}