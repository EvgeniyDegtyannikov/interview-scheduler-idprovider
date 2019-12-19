package com.netcracker.interviewscheduleridprovider.controllers;

import com.netcracker.interviewscheduleridprovider.services.UserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "")
    public HttpStatus createUser(@RequestBody UserRepresentation userRepresentation) {
        return userService.createUser(userRepresentation);
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    @PutMapping(value = "/{id}")
    public void editUser(@PathVariable String id, @RequestBody UserRepresentation userRepresentation) {
        userService.editUser(id, userRepresentation);
    }

    @GetMapping(value = "")
    public List<UserRepresentation> loadUsers() {
        return userService.loadUsers();
    }

    @GetMapping(value = "/{id}")
    public UserRepresentation loadUser(@PathVariable String id) {
        return userService.loadUser(id);
    }
}
