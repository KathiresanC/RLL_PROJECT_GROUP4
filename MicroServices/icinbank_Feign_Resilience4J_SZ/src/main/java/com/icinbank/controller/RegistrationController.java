package com.icinbank.controller;

import com.icinbank.model.User;
import com.icinbank.response.RegisterResponse;
import com.icinbank.proxy.RegistrationServiceProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/online-banking")
public class RegistrationController {

    private final RegistrationServiceProxy registrationServiceProxy;
    
    private Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(RegistrationServiceProxy registrationServiceProxy) {
        this.registrationServiceProxy = registrationServiceProxy;
    }

    @PostMapping("/register")
    public RegisterResponse createAccount(@RequestBody User user) {
    	log.debug("user registry...");
    	RegisterResponse res=registrationServiceProxy.createAccount(user);
    	log.debug("registration status of the user ===>"+res);
        return res;
    }

}