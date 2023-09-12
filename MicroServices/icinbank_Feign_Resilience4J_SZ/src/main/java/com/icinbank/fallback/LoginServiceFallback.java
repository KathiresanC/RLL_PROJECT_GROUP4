package com.icinbank.fallback;

import org.springframework.stereotype.Component;

import com.icinbank.details.LoginDetails;
import com.icinbank.proxy.LoginServiceProxy;
import com.icinbank.response.LoginResponse;

@Component
public class LoginServiceFallback implements LoginServiceProxy {

    @Override
    public LoginResponse customerLogin(LoginDetails details) {

        LoginResponse fallbackResponse = new LoginResponse();
        fallbackResponse.setLoginStatus(false);
        fallbackResponse.setResponseMessage("Service is currently unavailable. Please try again later.");
        return fallbackResponse;
    }
}
