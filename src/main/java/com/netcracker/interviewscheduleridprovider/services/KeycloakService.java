package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class KeycloakService {
    @Value("${keycloak.auth-server-url}")
    private String SERVER_URL;
    @Value("${keycloak.realm}")
    private String REALM;
    @Value("${my.keycloak.username}")
    private String USERNAME;
    @Value("${my.keycloak.password}")
    private String PASSWORD;
    @Value("${keycloak.resource}")
    private String CLIENT_ID;

    public Keycloak getInstance() {
        return KeycloakBuilder
                .builder()
                .serverUrl(SERVER_URL)
                .realm(REALM)
                .username(USERNAME)
                .password(PASSWORD)
                .clientId(CLIENT_ID)
                .build();
    }

    public String getREALM() {
        return REALM;
    }
}
