package com.example.springboot.ui.controller;

import com.example.springboot.ui.model.response.UserRest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String userId)
    {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Chathurika");
        returnValue.setLastName("Jayathilake");
        returnValue.setEmail("test@gmail.com");
        returnValue.setUserId(userId);
        return returnValue;
    }

    @PostMapping()
    public String createUser(@PathVariable String userId)
    {
        return "create user was called";
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