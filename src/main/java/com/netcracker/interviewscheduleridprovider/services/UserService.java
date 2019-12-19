package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {
    HttpStatus createUser(UserRepresentation userRepresentation);

    HttpStatus deleteUser(String id);

    void editUser(String id, UserRepresentation userRepresentation);

    List<UserRepresentation> loadUsers();

    UserRepresentation loadUser(String id);
}
