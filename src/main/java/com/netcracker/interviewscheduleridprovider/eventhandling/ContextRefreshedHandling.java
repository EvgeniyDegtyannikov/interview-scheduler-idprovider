package com.netcracker.interviewscheduleridprovider.eventhandling;

import com.netcracker.interviewscheduleridprovider.services.IdentityProviderBrokeringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedHandling {
    @Autowired
    IdentityProviderBrokeringService identityProviderBrokeringService;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        identityProviderBrokeringService.buildIdentityProviderForBrokering("google",
                "249116971264-3j4rdn9jqku1ps71sjadvrtf9eh4305t.apps.googleusercontent.com",
                "nVQxaoImGKF6kbN2GP70ekMy");
    }
}
