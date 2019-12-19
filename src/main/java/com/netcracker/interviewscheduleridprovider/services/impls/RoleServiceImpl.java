package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.KeycloakInstance;
import com.netcracker.interviewscheduleridprovider.services.RoleService;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    KeycloakInstance keycloakInstance;

    @Override
    public void createRole(RoleRepresentation roleRepresentation) {
        keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .roles()
                .create(roleRepresentation);
        System.out.println("Role created:    " + roleRepresentation.getName());
    }

    @Override
    public void editRole(String id, RoleRepresentation roleRepresentation) {
        keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .rolesById()
                .updateRole(id, roleRepresentation);
        System.out.println("Role updated    " + id);
    }

    @Override
    public void deleteRole(String id) {
        keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .rolesById()
                .deleteRole(id);
        System.out.println("Role deleted    " + id);
    }

    @Override
    public List<RoleRepresentation> loadRoles() {
        return keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .roles()
                .list();
    }

    @Override
    public RoleRepresentation loadRole(String id) {
        return keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .rolesById()
                .getRole(id);
    }
}
