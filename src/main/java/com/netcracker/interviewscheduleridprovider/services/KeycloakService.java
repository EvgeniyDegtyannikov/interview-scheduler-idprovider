package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakService {
    public static final String SERVER_URL="http://localhost:8080/auth";
    public static final String REALM="netcracker-scheduler-keycloak-base";
    private static final String USERNAME="admin";
    private static final String PASSWORD="admin";
    public static final String CLIENT_ID="idprovider-app";

    public static Keycloak getInstance() {
        return KeycloakBuilder
                .builder()
                .serverUrl(SERVER_URL)
                .realm(REALM)
                .username(USERNAME)
                .password(PASSWORD)
                .clientId(CLIENT_ID)
                .build();
    }
}
