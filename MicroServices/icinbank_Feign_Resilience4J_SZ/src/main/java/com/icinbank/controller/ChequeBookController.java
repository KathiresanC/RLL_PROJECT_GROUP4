package com.icinbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.icinbank.model.ChequebookRequest;
import com.icinbank.response.ChequeResponse;
import com.icinbank.proxy.ChequeBookServiceProxy;

@RestController
@RequestMapping("/online-banking")
public class ChequeBookController {

    @Autowired
    private ChequeBookServiceProxy chequeBookServiceProxy;
    
    private Logger log = LoggerFactory.getLogger(ChequeBookController.class);

    @PostMapping("/cheque/request")
    public ChequeResponse createRequest(@RequestBody ChequebookRequest chequebook) {
    	ChequeResponse rep=chequeBookServiceProxy.createRequest(chequebook);
    	log.debug("The Account Details ===>"+rep);
        return rep;
    }

    @GetMapping("/cheque/getbyAccount")
    public List<ChequebookRequest> getRequests(@RequestParam("account") long account) {
    	log.debug("Account no ===>"+account);
    	List<ChequebookRequest> acc= chequeBookServiceProxy.getRequests(account);
        log.debug("The Account Details ===>"+acc);
        return acc;
    }
}
