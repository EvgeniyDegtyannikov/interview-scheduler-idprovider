package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.GroupService;
import com.netcracker.interviewscheduleridprovider.services.KeycloakService;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    KeycloakService keycloakService;

    @Override
    public void createGroup(GroupRepresentation groupRepresentation) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .groups()
                .add(groupRepresentation);
    }

    @Override
    public void editGroup(String name, GroupRepresentation groupRepresentation) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .groups()
                .group(getGroupIdByName(name))
                .update(groupRepresentation);
    }

    @Override
    public void deleteGroup(String name) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .groups()
                .group(getGroupIdByName(name))
                .remove();
    }

    private String getGroupIdByName(String name) {
        return keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .getGroupByPath("/" + name).getId();
    }
}
