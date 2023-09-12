package com.admin.fallback;

import com.admin.model.ChequebookRequest;
import com.admin.model.UserDisplay;
import com.admin.service.AdminServiceProxy;

import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

@Component
public class AdminServiceProxyFallback implements AdminServiceProxy {

    @Override
    public void setUserFeatures(String username, int featureId) {
    }

    @Override
    public List<UserDisplay> getAllUsers() {
        return Collections.emptyList();

    }

    @Override
    public List<ChequebookRequest> getAllChequeBookRequests() {

        return Collections.emptyList();
    }

    @Override
    public void confirmChequeBookRequest(long accNo) {

    }

    @Override
    public void enableUser(String username) {
    }

    @Override
    public void disableUser(String username) {
    }

}
