package com.icinbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.icinbank.details.UpdateDetails;
import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;
import com.icinbank.proxy.ProfileServiceProxy;
import com.icinbank.response.UpdateResponse;

@RestController
@RequestMapping("online-banking")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfileController {

    @Autowired
    private ProfileServiceProxy profileServiceProxy;
    
    private Logger log = LoggerFactory.getLogger(ProfileController.class);

    @PutMapping("/update")
    public UpdateResponse updateUser(@RequestBody UpdateDetails userDetails) {
    	log.debug("update user.....");
    	UpdateResponse res=profileServiceProxy.updateUser(userDetails);
    	log.debug("Userdatils ===> "+res);
    	return res;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
    	log.debug("username ===> "+username);
    	User res=profileServiceProxy.getUser(username);
    	log.debug("Userdatils ===> "+res);
    	return res; 
    }

    @GetMapping("/display/{username}")
    public UserDisplay userDisplay(@PathVariable String username) {
    	log.debug("username ===> "+username);
    	UserDisplay res=profileServiceProxy.userDisplay(username);
    	log.debug("Userdatils ===> "+res);
    	return res; 
    }
}
