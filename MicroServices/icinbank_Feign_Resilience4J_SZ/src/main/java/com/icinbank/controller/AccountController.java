package com.icinbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.icinbank.details.TransactionDetails;
import com.icinbank.details.TransferDetails;
import com.icinbank.model.Account;
import com.icinbank.model.Saccount;
import com.icinbank.model.Transfer;
import com.icinbank.model.UserHistory;
import com.icinbank.proxy.AccountServiceProxy;
import com.icinbank.response.DepositResponse;
import com.icinbank.response.TransferResponse;
import com.icinbank.response.WithdrawResponse;


@RestController
@RequestMapping("/online-banking")
public class AccountController {

    @Autowired
    private AccountServiceProxy accountServiceProxy;
    
    private Logger log = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/account-details/{account}")
    public Account getAccountDetails(@PathVariable("account") long account) {
    	log.debug("Account no ===>"+account);
    	Account acc=accountServiceProxy.getAccountDetails(account);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }

    @PutMapping("/update-account")
    public Account updateAccount(@RequestBody Account account) {
    	log.debug("Account no ===>"+account);
    	Account acc=accountServiceProxy.updateAccount(account);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }
    
    @GetMapping("/account/getprimary/{username}")
    public Account getPrimaryDetails(@PathVariable("username") String username) {
    	log.debug("Username ===>"+username);
    	Account acc=accountServiceProxy.getPrimaryDetails(username);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }

    @GetMapping("/account/getsaving/{username}")
    public Saccount getSavingDetails(@PathVariable("username") String username) {
    	log.debug("Username ===>"+username);
    	Saccount acc=accountServiceProxy.getSavingDetails(username);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }

    @PostMapping("/deposit")
    public DepositResponse deposit(@RequestBody TransactionDetails details) {
    	DepositResponse acc=accountServiceProxy.deposit(details);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }

    @PostMapping("/withdraw")
    public WithdrawResponse withdraw(@RequestBody TransactionDetails details) {
    	WithdrawResponse acc=accountServiceProxy.withdraw(details);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }

    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferDetails details) {
    	TransferResponse acc=accountServiceProxy.transfer(details);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }

    @GetMapping("/account-history/{account}")
    public List<UserHistory> getAccountHistory(@PathVariable("account") long account) {
    	log.debug("Account no ===>"+account);
    	List<UserHistory> acc=accountServiceProxy.getAccountHistory(account);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }
    
    @GetMapping("/account-Transfers/{account}")
	public List<Transfer> getTransfers(@PathVariable("account") long account ){
    	log.debug("Account no ===>"+account);
    	List<Transfer> acc=accountServiceProxy.getTransfers(account);
    	log.debug("The Account Details ===>"+acc);
        return acc;
    }
}
