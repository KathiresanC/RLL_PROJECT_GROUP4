package com.admin.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dao.AccountRepository;
import com.admin.dao.ChequeBookRequestsRepository;
import com.admin.dao.SaccountRepository;
import com.admin.dao.UserDisplayRepository;
import com.admin.dao.UserRepository;
import com.admin.model.ChequebookRequest;
import com.admin.model.User;
import com.admin.model.UserDisplay;
import com.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	private ChequeBookRequestsRepository chequeBookDAO;
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private UserDisplayRepository displayDao;
	
	@Autowired
	private AccountRepository accDao;
	
	@Autowired
	private SaccountRepository sAccDao;
	


	@Override
	public void acceptChequebookRequest(long accNo) {
		String username = "";
		chequeBookDAO.setChequebookInfoByAccount(accNo);
		if(Long.toString(accNo).length() == 7) {
			username = accDao.findByAccno(accNo).getUsername();
		}
		else {
			username = sAccDao.findByAccno(accNo).getUsername();
		}
	}

	@Override
	public void enableUser(String username) {
		userDao.enableUser(username);
		
	}

	@Override
	public void disableUser(String username) {
		userDao.disableUser(username);
		
	}
	

	@Override
	public List<UserDisplay> getAllUsers() {
		return displayDao.getAllUsers();
	}

	
	@Override
	public List<ChequebookRequest> getAllChequebookRequests() {
		return chequeBookDAO.findAllChequebookRequests();
	}

	@Override
	public void setUserFeatures(String username, int featureId) {
		userDao.setUserFeatureStatus(username,featureId);
		
	}
	
	static boolean isNumber(String s) 
    { 
        for (int i = 0; i < s.length(); i++) 
        if (Character.isDigit(s.charAt(i))  
            == false) 
            return false; 
  
        return true; 
    } 

	@Override
	public UserDisplay searchUser(String userDetail) {
		if(isNumber(userDetail)) {
			return displayDao.getUserDetailsByAccountNo(Long.parseLong(userDetail));
		}
		else {
			return displayDao.getUserDetailsByUsername(userDetail);
		}
		
	}
	
	@Override
	public void authorizeUser(String username) {
		userDao.authorizeUser(username);
		
	}
	

}
