package com.icinbank.fallback;

import com.icinbank.model.User;
import com.icinbank.proxy.RegistrationServiceProxy;
import com.icinbank.response.RegisterResponse;

import org.springframework.stereotype.Component;

@Component
public class RegistrationServiceFallback implements RegistrationServiceProxy {

    @Override
    public RegisterResponse createAccount(User user) {
        // Fallback logic for createAccount
        RegisterResponse response = new RegisterResponse();
        response.setRegistrationStatus(false);
        response.setResponseMessage("Fallback: Account creation failed");
        return response;
    }
}
