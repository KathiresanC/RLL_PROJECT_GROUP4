package com.admin.service;

import java.util.List;

import com.admin.model.ChequebookRequest;
import com.admin.model.UserDisplay;

public interface AdminService {
	
	public List<UserDisplay> getAllUsers();
	public List<ChequebookRequest> getAllChequebookRequests();
	public void enableUser(String username);
	public void disableUser(String username);
	public void setUserFeatures(String username, int featureId);
	public UserDisplay searchUser(String userDetail);
	void acceptChequebookRequest(long accNo);
	
}
