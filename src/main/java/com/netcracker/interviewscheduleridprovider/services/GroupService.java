package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface GroupService {
    HttpStatus createGroup(GroupRepresentation groupRepresentation);

    void editGroup(String id, GroupRepresentation groupRepresentation);

    void deleteGroup(String id);

    List<GroupRepresentation> loadGroups();

    GroupRepresentation loadGroup(String id);
}
