package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.KeycloakService;
import com.netcracker.interviewscheduleridprovider.services.UserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    KeycloakService keycloakService;

    @Override
    public void createUser(UserRepresentation userRepresentation) {
        userRepresentation.setUsername(userRepresentation.getEmail());
        userRepresentation.setEnabled(true);
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .users()
                .create(userRepresentation);
    }

    @Override
    public void deleteUser(String id) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .users()
                .delete(id);
    }

    @Override
    public void editUser(String id, UserRepresentation userRepresentation) {
        keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .users()
                .get(id)
                .update(userRepresentation);
    }

    @Override
    public List<UserRepresentation> loadUsers() {
        return keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .users()
                .list();
    }

    @Override
    public UserRepresentation loadUser(String id) {
        return keycloakService.getInstance()
                .realm(keycloakService.getREALM())
                .users()
                .get(id)
                .toRepresentation();
    }
}
