package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.KeycloakService;
import com.netcracker.interviewscheduleridprovider.services.RoleService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    KeycloakService keycloakService;

    @Override
    public void createRole(RoleRepresentation roleRepresentation) {
        keycloakService.getInstance().realm(keycloakService.getREALM()).roles().create(roleRepresentation);
    }

    @Override
    public void editRole(String name, RoleRepresentation roleRepresentation) {
        keycloakService.getInstance().realm(keycloakService.getREALM()).roles().get(name).update(roleRepresentation);
    }

    @Override
    public void deleteRole(String name) {
        keycloakService.getInstance().realm(keycloakService.getREALM()).roles().deleteRole(name);
    }
}
