package com.netcracker.interviewscheduleridprovider.services;

public interface IdentityProviderBrokeringService {
    void buildIdentityProviderForBrokering(String provider, String clientId, String clientSecret);
}
