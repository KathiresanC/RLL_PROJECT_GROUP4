package com.icinbank.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.dao.AccountRepository;
import com.icinbank.dao.SaccountRepository;
import com.icinbank.details.TransactionDetails;
import com.icinbank.details.TransferDetails;
import com.icinbank.model.Account;
import com.icinbank.model.Saccount;
import com.icinbank.model.Transfer;
import com.icinbank.model.UserHistory;
import com.icinbank.response.DepositResponse;
import com.icinbank.response.TransferResponse;
import com.icinbank.response.WithdrawResponse;
import com.icinbank.service.AccountService;
import com.icinbank.service.SaccountService;
import com.icinbank.service.TransferHistoryService;
import com.icinbank.service.UserHistoryService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@Autowired 
	private SaccountService sservice;
	
	@Autowired
	private UserHistoryService hservice;
	
	@Autowired
	private TransferHistoryService tservice;
	
	@Autowired
	private AccountRepository adao;
	
	@Autowired
	private SaccountRepository sdao;
	
	private Logger log = LoggerFactory.getLogger(AccountController.class);
	
	private final String ifsc="ICIN7465";
	
	public static boolean isprimary(long account) {
		String s = Long.toString(account).substring(0, 10);
		String check="3914918201";
		if(s.equals(check)) {
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	@GetMapping("/account/details/{account}")
	public Account getAccountDetails(@PathVariable("account") long account ) {
		log.debug("Account no ===>" +account);
		Account acc=service.getAccountDetails(account);
		log.debug("Account details ===>"+acc);
		return acc;
	}
	
	@PutMapping("/account/profile")
	public Account updateProfile(@RequestBody Account account) {
		log.debug("Account no ===>" +account);
		Account acc=service.updateAccount(account);
		log.debug("Account details ===>"+acc);
		return acc;
	}
	
	@GetMapping("/account/getprimary/{username}")
	public Account getPrimarydetails(@PathVariable("username") String username) {
		log.debug("Account username ===>" +username);
		Account acc=service.getAccount(username);
		log.debug("Account details ===>"+acc);
		return acc;
	}
	
	@GetMapping("/account/getsaving/{username}")
	public Saccount getSavingdetails(@PathVariable("username") String username) {
		log.debug("Account username ===>" +username);
		Saccount acc=sservice.getAccount(username);
		log.debug("Account details ===>"+acc);
		return acc;
	}
	
	@PostMapping("/account/deposit")
	public DepositResponse deposit(@RequestBody TransactionDetails details) {
		//adao.findByUsername(adao.findByAccno(details.getAccount()).getUsername());
		if(isprimary(details.getAccount())) {
			return service.deposit(details.getAccount(), details.getAmount());
		}
		else {
			return sservice.deposit(details.getAccount(), details.getAmount());
		}
	}
	
	@PostMapping("/account/withdraw")
	public WithdrawResponse withdraw(@RequestBody TransactionDetails details) {
		log.debug("In withdraw ");
		if(isprimary(details.getAccount())) {
		WithdrawResponse res=service.withdraw(details.getAccount(), details.getAmount());
		log.debug("withdraw details ===>"+res);
		return res;
		}
		else {
			WithdrawResponse res=sservice.withdraw(details.getAccount(), details.getAmount());
			log.debug("withdraw details ===>"+res);
			return res;
		}
	}
	
	@PostMapping("/account/transfer")
	public TransferResponse transfer(@RequestBody TransferDetails details) {
		try {
			log.debug("In tansfer ");
			if(details.getIfsc().equals(ifsc)) 
			{
						Account p=adao.findByUsername(details.getUsername());
						Saccount s=sdao.findByUsername(details.getUsername());
						
						if(p.getAccno()==details.getSaccount() || s.getAccno()==details.getSaccount()) {
						//String len = Integer.toString(details.getSaccount());
						if(isprimary(details.getSaccount())) {
						TransferResponse sts= service.transfer(details.getSaccount(), details.getRaccount(), details.getAmount());
						return sts;
						}
						else
						{
							TransferResponse sts=sservice.transfer(details.getSaccount(), details.getRaccount(), details.getAmount());
							return sts;
						}
						}
						else {
							TransferResponse response=new TransferResponse();
							response.setSaccount(details.getSaccount());
							response.setResponseMessage("Dear User, You can only transfer funds from the accounts registered with you");
							response.setTransferStatus(false);
							log.debug("response ===>"+response);
							return response;
			}
			}
			else {
				TransferResponse response=new TransferResponse();
						response.setSaccount(details.getSaccount());
						response.setResponseMessage("IFSC code is incorrect");
						response.setTransferStatus(false);
						log.debug("response ===>"+response);
						return response;
			}
		} catch (Exception e) {
			TransferResponse response=new TransferResponse();
			response.setSaccount(details.getSaccount());
			response.setResponseMessage("Please provide an IFSC code");
			response.setTransferStatus(false);
			log.debug("response ===>"+response);
			return response;
			
		}
	}
	
	@GetMapping("/account/getHistory/{account}")
	public List<UserHistory> getHistory(@PathVariable("account") long account )
	{
		log.debug("Account no ===>" +account);
		List<UserHistory> history=hservice.getHistory(account);
		Collections.reverse(history);
		log.debug("Account history ===>"+history);
		return history;
	}
	
	@GetMapping("/account/getTransfers/{account}")
	public List<Transfer> getTransfers(@PathVariable("account") long account )
	{
		log.debug("Account no ===>" +account);
		List<Transfer> acc=tservice.getTransfers(account);
		log.debug("Account transfers ===>"+acc);
		return acc;
	}


}
