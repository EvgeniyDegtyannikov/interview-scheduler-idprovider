package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.KeycloakInstance;
import com.netcracker.interviewscheduleridprovider.services.UserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    KeycloakInstance keycloakInstance;

    @Override
    public HttpStatus createUser(UserRepresentation userRepresentation) {
        userRepresentation.setUsername(userRepresentation.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.getCredentials().get(0).setTemporary(true);
        Response response = keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .users()
                .create(userRepresentation);
        System.out.println("User create status info:    " +
                response.getStatusInfo() + "  " +
                userRepresentation.getUsername());
        return HttpStatus.valueOf(response.getStatusInfo().getStatusCode());
    }

    @Override
    public HttpStatus deleteUser(String id) {
        Response response = keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .users()
                .delete(id);
        System.out.println("User delete status info:    " +
                response.getStatusInfo() + "  " + id);
        return HttpStatus.valueOf(response.getStatusInfo().getStatusCode());
    }

    @Override
    public void editUser(String id, UserRepresentation userRepresentation) {
        keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .users()
                .get(id)
                .update(userRepresentation);
        System.out.println("User update status info:    " + id);
    }

    @Override
    public List<UserRepresentation> loadUsers() {
        return keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .users()
                .list();
    }

    @Override
    public UserRepresentation loadUser(String id) {
        return keycloakInstance.getInstance()
                .realm(keycloakInstance.getREALM())
                .users()
                .get(id)
                .toRepresentation();
    }
}
