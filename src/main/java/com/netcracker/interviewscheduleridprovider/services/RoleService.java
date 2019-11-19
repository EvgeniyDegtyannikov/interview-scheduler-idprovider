package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.representations.idm.RoleRepresentation;

public interface RoleService {
    void createRole(RoleRepresentation roleRepresentation);

    void editRole(String name, RoleRepresentation roleRepresentation);

    void deleteRole(String name);
}
