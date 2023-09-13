package com.icinbank.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.icinbank.details.LoginDetails;
import com.icinbank.response.LoginResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "online-banking")
public interface LoginServiceProxy {

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForCustomerLogin")
    @PostMapping("/login")
    LoginResponse customerLogin(@RequestBody LoginDetails details);
	
	
	default LoginResponse fallbackMethodForCustomerLogin(LoginDetails details, Throwable throwable) {

		    LoginResponse fallbackResponse = new LoginResponse();
	        fallbackResponse.setLoginStatus(false);
	        fallbackResponse.setResponseMessage("Service is currently unavailable. Please try again later.");
	        return fallbackResponse;  
	    }	
}
