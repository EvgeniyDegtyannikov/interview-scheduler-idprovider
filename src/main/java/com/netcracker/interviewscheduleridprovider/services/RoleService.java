package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

public interface RoleService {
    void createRole(RoleRepresentation roleRepresentation);

    void editRole(String id, RoleRepresentation roleRepresentation);

    void deleteRole(String id);

    List<RoleRepresentation> loadRoles();

    RoleRepresentation loadRole(String id);
}
