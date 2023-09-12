package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.ChequebookRequest;
import com.admin.model.UserDisplay;
import com.admin.service.impl.AdminServiceImpl;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminServiceImpl service;

	
	@GetMapping("user/{username}/features/{featureId}")
	public void setUserFeatures(@PathVariable("username") String username, @PathVariable("featureId") int featureId) {
		service.setUserFeatures(username, featureId);
	}

	
	@GetMapping("/user/all")
	public List<UserDisplay> getAllUsers()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("/chequebook/request/all")
	public List<ChequebookRequest> getAllChequeBookRequests()
	{
		return service.getAllChequebookRequests();
	}
	
	@GetMapping("/user/{accNo}/chequebook/request/confirm")
	public ResponseEntity<String> confirmChequeBookRequest(@PathVariable("accNo") long accNo)
	{
		service.acceptChequebookRequest(accNo);
		 String message = "Chequebook request is accepted";
	     return ResponseEntity.ok(message);
	}
	
	@GetMapping("/user/{username}/enable")
	public ResponseEntity<String> enableUser(@PathVariable("username") String username)
	{
		service.enableUser(username);
		 String message = "user enabled";
	     return ResponseEntity.ok(message);
	}
	
	@GetMapping("/user/{username}/disable")
	public ResponseEntity<String> disableUser(@PathVariable("username") String username)
	{
		service.disableUser(username);
		String message = "User disabled";
        return ResponseEntity.ok(message);
	}
	
}
