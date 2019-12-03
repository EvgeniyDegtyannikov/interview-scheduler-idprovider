package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.GroupService;
import com.netcracker.interviewscheduleridprovider.services.KeycloakService;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void editGroup(String id, GroupRepresentation groupRepresentation) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .groups()
                .group(id)
                .update(groupRepresentation);
    }

    @Override
    public void deleteGroup(String id) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .groups()
                .group(id)
                .remove();
    }

    @Override
    public List<GroupRepresentation> loadGroups() {
        return keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .groups()
                .groups();
    }

    @Override
    public GroupRepresentation loadGroup(String id) {
        return keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .groups()
                .group(id)
                .toRepresentation();
    }
}
