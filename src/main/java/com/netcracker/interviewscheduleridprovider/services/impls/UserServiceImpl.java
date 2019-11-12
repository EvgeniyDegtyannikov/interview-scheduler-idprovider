package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.KeycloakService;
import com.netcracker.interviewscheduleridprovider.services.UserService;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public int createUser(String username, String password) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setFirstName("First Name");
        user.setLastName("Last Name");
        user.setEmail("q@netcracker.com");
        user.setCredentials(Arrays.asList(credential));
        user.setEnabled(true);
        javax.ws.rs.core.Response response = KeycloakService.getInstance().realm(KeycloakService.REALM).users().create(user);
        final int status = response.getStatus();
        if (status != HttpStatus.CREATED.value()) {
            return status;
        }
        return HttpStatus.CREATED.value();
    }

    @Override
    public int deleteUser(String id){
        javax.ws.rs.core.Response response = KeycloakService.getInstance().realm(KeycloakService.REALM).users().delete(id);
        final int status = response.getStatus();
        if (status != HttpStatus.CREATED.value()) {
            return status;
        }
        return HttpStatus.CREATED.value();
    }

    @Override
    public void editUser(String id){
        UserRepresentation user = new UserRepresentation();
        user.setUsername("changed");
        user.setFirstName("changed");
        user.setLastName("Last Name");
        user.setEmail("changed@netcracker.com");
        user.setEnabled(true);
        KeycloakService.getInstance().realm(KeycloakService.REALM).users().get(id).update(user);

    }
}
