package com.icinbank.fallback;

import org.springframework.stereotype.Component;

import com.icinbank.model.ChequebookRequest;
import com.icinbank.proxy.ChequeBookServiceProxy;
import com.icinbank.response.ChequeResponse;

import java.util.Collections; // Add this import
import java.util.List;

@Component
public class ChequeBookServiceFallback implements ChequeBookServiceProxy {

    @Override
    public ChequeResponse createRequest(ChequebookRequest chequebook) {
    	 ChequeResponse response = new ChequeResponse();
         response.setStatus(false);
         response.setResponseMessage("Fallback: Request creation failed");
         return response;
    }

    @Override
    public List<ChequebookRequest> getRequests(long account) {
        return Collections.emptyList();
    }
}
