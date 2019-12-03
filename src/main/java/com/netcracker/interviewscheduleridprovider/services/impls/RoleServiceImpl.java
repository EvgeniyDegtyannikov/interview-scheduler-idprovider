package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.KeycloakService;
import com.netcracker.interviewscheduleridprovider.services.RoleService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    KeycloakService keycloakService;

    @Override
    public void createRole(RoleRepresentation roleRepresentation) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .roles()
                .create(roleRepresentation);
    }

    @Override
    public void editRole(String id, RoleRepresentation roleRepresentation) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .rolesById()
                .updateRole(id, roleRepresentation);
    }

    @Override
    public void deleteRole(String id) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .rolesById()
                .deleteRole(id);
    }

    @Override
    public List<RoleRepresentation> loadRoles() {
        return keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .roles()
                .list();
    }

    @Override
    public RoleRepresentation loadRole(String id) {
        return keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .rolesById()
                .getRole(id);
    }
}
