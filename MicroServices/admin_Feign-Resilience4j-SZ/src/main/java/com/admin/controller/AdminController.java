package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.admin.model.ChequebookRequest;
import com.admin.model.UserDisplay;
import com.admin.service.AdminServiceProxy;

import java.util.List;

@RestController
@RequestMapping("/admin") 
public class AdminController {

    private final AdminServiceProxy adminServiceProxy;

    @Autowired
    public AdminController(AdminServiceProxy adminServiceProxy) {
        this.adminServiceProxy = adminServiceProxy;
    }

    @GetMapping("/user/{username}/features/{featureId}")
    public void setUserFeatures(@PathVariable("username") String username, @PathVariable("featureId") int featureId) {
        adminServiceProxy.setUserFeatures(username, featureId);
    }

    @GetMapping("/user/all")
    public List<UserDisplay> getAllUsers() {
        return adminServiceProxy.getAllUsers();
    }

    @GetMapping("/chequebook/request/all")
    public List<ChequebookRequest> getAllChequeBookRequests() {
        return adminServiceProxy.getAllChequeBookRequests();
    }

    @GetMapping("/user/{accNo}/chequebook/request/confirm")
    public ResponseEntity<String> confirmChequeBookRequest(@PathVariable("accNo") long accNo) {
        adminServiceProxy.confirmChequeBookRequest(accNo);
        String message = "Chequebook request is accepted";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/user/{username}/enable")
    public ResponseEntity<String> enableUser(@PathVariable("username") String username) {
        adminServiceProxy.enableUser(username);
        String message = "user enabled";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/user/{username}/disable")
    public ResponseEntity<String> disableUser(@PathVariable("username") String username) {
        adminServiceProxy.disableUser(username);
        String message = "User disabled";
        return ResponseEntity.ok(message);
    }
    
    @GetMapping("/user/{username}/authorize")
    public ResponseEntity<String> authorizeUser(@PathVariable("username") String username) {
    	adminServiceProxy.authorizeUser(username);
        String message = "User Authorized";
        return ResponseEntity.ok(message);
    }
}
