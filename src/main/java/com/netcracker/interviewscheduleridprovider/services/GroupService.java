package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.representations.idm.GroupRepresentation;

public interface GroupService {
    void createGroup(GroupRepresentation groupRepresentation);

    void editGroup(String name, GroupRepresentation groupRepresentation);

    void deleteGroup(String name);
}
