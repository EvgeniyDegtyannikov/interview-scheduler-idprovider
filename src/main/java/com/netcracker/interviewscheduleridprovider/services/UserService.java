package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.representations.idm.UserRepresentation;

public interface UserService {
    void createUser(UserRepresentation userRepresentation);

    void deleteUser(String id);

    void editUser(String id, UserRepresentation userRepresentation);
}
