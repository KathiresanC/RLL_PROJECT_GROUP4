package com.icinbank.proxy;

import com.icinbank.details.UpdateDetails;
import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;
import com.icinbank.response.UpdateResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "online-banking")
public interface ProfileServiceProxy {

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForUpdateUser")
    @PutMapping("/profile/update")
    UpdateResponse updateUser(@RequestBody UpdateDetails user);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetUser")
    @GetMapping("/profile/{username}")
    User getUser(@PathVariable("username") String username);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForUserDisplay")
    @GetMapping("/home/{username}")
    UserDisplay userDisplay(@PathVariable("username") String username);
	
	default UpdateResponse fallbackMethodForUpdateUser(UpdateDetails user, Throwable throwable) {
	    	UpdateResponse res=new UpdateResponse();
	    	res.setFlag(true);
	    	res.setMessage("success....");
	    	return res;
	    	
	    }

	default User fallbackMethodForGetUser(String username, Throwable throwable) {
	       User us=new User();
	       us.setUsername("default");
	       us.setEmail("admin@gmail.com");
	       return us;
	    }

	default UserDisplay fallbackMethodForUserDisplay(String username, Throwable throwable) {
	    	UserDisplay us=new UserDisplay();
	        us.setUsername("default");
	        us.setPrimaryAccno(1234);
	        us.setSavingsAccno(345);
	        return us;
	    }
}
