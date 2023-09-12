package com.icinbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.details.LoginDetails;
import com.icinbank.proxy.LoginServiceProxy;
import com.icinbank.response.LoginResponse;

@RestController
@RequestMapping("/online-banking")
public class LoginController {

	@Autowired
    private LoginServiceProxy loginServiceProxy;
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping("/login")
    public LoginResponse userLogin(@RequestBody LoginDetails details) {
		LoginResponse rep=loginServiceProxy.customerLogin(details);
		log.debug("The Account Details ===>"+rep);
        return rep;
    }
}
