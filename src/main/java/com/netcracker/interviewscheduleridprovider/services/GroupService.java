package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.representations.idm.GroupRepresentation;

import java.util.List;

public interface GroupService {
    void createGroup(GroupRepresentation groupRepresentation);

    void editGroup(String id, GroupRepresentation groupRepresentation);

    void deleteGroup(String id);

    List<GroupRepresentation> loadGroups();

    GroupRepresentation loadGroup(String id);
}
