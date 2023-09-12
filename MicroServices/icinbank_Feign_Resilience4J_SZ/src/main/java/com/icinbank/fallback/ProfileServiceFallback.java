package com.icinbank.fallback;

import com.icinbank.details.UpdateDetails;
import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;
import com.icinbank.proxy.ProfileServiceProxy;
import com.icinbank.response.UpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class ProfileServiceFallback implements ProfileServiceProxy {

    @Override
    public UpdateResponse updateUser(UpdateDetails user) {
    	UpdateResponse res=new UpdateResponse();
    	res.setFlag(true);
    	res.setMessage("success....");
    	return res;
    	
    }

    @Override
    public User getUser(String username) {
       User us=new User();
       us.setUsername("default");
       us.setEmail("admin@gmail.com");
       return us;
    }

    @Override
    public UserDisplay userDisplay(String username) {
    	UserDisplay us=new UserDisplay();
        us.setUsername("default");
        us.setPrimaryAccno(1234);
        us.setSavingsAccno(345);
        return us;
    }
}
