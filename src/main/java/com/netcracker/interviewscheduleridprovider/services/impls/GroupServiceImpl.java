package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.GroupService;
import com.netcracker.interviewscheduleridprovider.services.KeycloakInstance;
import org.keycloak.representations.idm.GroupRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    KeycloakInstance keycloakInstance;

    @Override
    public HttpStatus createGroup(GroupRepresentation groupRepresentation) {
        Response response = keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .groups()
                .add(groupRepresentation);
        System.out.println("Group create status info:    " +
                response.getStatusInfo() + "  " +
                groupRepresentation.getName());
        return HttpStatus.valueOf(response.getStatusInfo().getStatusCode());
    }

    @Override
    public void editGroup(String id, GroupRepresentation groupRepresentation) {
        keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .groups()
                .group(id)
                .update(groupRepresentation);
        System.out.println("Group update status info:    " + id);
    }

    @Override
    public void deleteGroup(String id) {
        keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .groups()
                .group(id)
                .remove();
        System.out.println("Group delete status info:    " + id);
    }

    @Override
    public List<GroupRepresentation> loadGroups() {
        return keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .groups()
                .groups();
    }

    @Override
    public GroupRepresentation loadGroup(String id) {
        return keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .groups()
                .group(id)
                .toRepresentation();
    }
}
