package com.netcracker.interviewscheduleridprovider.services;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@PropertySource("classpath:application.properties")
public class KeycloakInstance {
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

    private Keycloak keycloakInstance;

    public Keycloak getInstance() {
        return keycloakInstance;
    }

    public String getREALM() {
        return REALM;
    }

    @PostConstruct
    public void init() {
        keycloakInstance = KeycloakBuilder
                .builder()
                .serverUrl(SERVER_URL)
                .realm(REALM)
                .username(USERNAME)
                .password(PASSWORD)
                .clientId(CLIENT_ID)
                .build();
    }
}
