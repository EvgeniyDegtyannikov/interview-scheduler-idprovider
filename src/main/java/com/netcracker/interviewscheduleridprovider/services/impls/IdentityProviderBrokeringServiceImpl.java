package com.netcracker.interviewscheduleridprovider.services.impls;

import com.netcracker.interviewscheduleridprovider.services.IdentityProviderBrokeringService;
import com.netcracker.interviewscheduleridprovider.services.KeycloakInstance;
import org.keycloak.representations.idm.IdentityProviderRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
public class IdentityProviderBrokeringServiceImpl implements IdentityProviderBrokeringService {
    @Autowired
    KeycloakInstance keycloakInstance;

    @Override
    public void buildIdentityProviderForBrokering(String provider, String clientId, String clientSecret) {
        IdentityProviderRepresentation representation = new IdentityProviderRepresentation();
        representation.setAlias(provider);
        representation.setDisplayName(provider);
        representation.setProviderId(provider);
        representation.setEnabled(true);
        representation.getConfig().put("clientId", clientId);
        representation.getConfig().put("clientSecret", clientSecret);
        Response response = keycloakInstance.getInstance().realm(keycloakInstance.getREALM())
                .identityProviders()
                .create(representation);
        System.out.println("IdProvider create status info:    " +
                response.getStatusInfo() + "  " +
                representation.getDisplayName());
    }
}
