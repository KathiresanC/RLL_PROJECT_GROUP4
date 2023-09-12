package com.icinbank.proxy;


import com.icinbank.model.User;
import com.icinbank.response.RegisterResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "online-banking") 
public interface RegistrationServiceProxy {

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForCreateAccount")
    @PostMapping("/register")
    RegisterResponse createAccount(@RequestBody User user);
	
	default RegisterResponse fallbackMethodForCreateAccount(User user, Throwable throwable) {
		RegisterResponse response = new RegisterResponse();
		response.setUsername("Kathir");
        response.setRegistrationStatus(false);
        response.setResponseMessage("Fallback: Account creation failed");
        return response; 
    }
}
