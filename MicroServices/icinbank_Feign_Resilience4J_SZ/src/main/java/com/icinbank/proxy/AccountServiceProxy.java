package com.icinbank.proxy;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.icinbank.details.TransactionDetails;
import com.icinbank.details.TransferDetails;
import com.icinbank.model.Account;
import com.icinbank.model.Saccount;
import com.icinbank.model.Transfer;
import com.icinbank.model.UserHistory;
import com.icinbank.response.DepositResponse;
import com.icinbank.response.TransferResponse;
import com.icinbank.response.WithdrawResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;




@FeignClient(name = "online-banking")
public interface AccountServiceProxy {

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetAccountDetails")
    @GetMapping("/account/details/{account}")
    Account getAccountDetails(@PathVariable("account") long account);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForUpdateAccount")
    @PutMapping("/account/profile")
    Account updateAccount(@RequestBody Account account);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetPrimaryDetails")
    @GetMapping("/account/getprimary/{username}")
    Account getPrimaryDetails(@PathVariable("username") String username);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetSavingDetails")
    @GetMapping("/account/getsaving/{username}")
    Saccount getSavingDetails(@PathVariable("username") String username);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForDeposit")
    @PostMapping("/account/deposit")
    DepositResponse deposit(@RequestBody TransactionDetails details);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForWithdraw")
    @PostMapping("/account/withdraw")
    WithdrawResponse withdraw(@RequestBody TransactionDetails details);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForTransfer")
    @PostMapping("/account/transfer")
    TransferResponse transfer(@RequestBody TransferDetails details);

	@Retry(name="online-banking")
    @CircuitBreaker(name = "accountService", fallbackMethod = "fallbackMethodForGetAccountHistory")
    @GetMapping("/account/getHistory/{account}")
    List<UserHistory> getAccountHistory(@PathVariable("account") long account);
 
	@Retry(name="online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetTransfers")
    @GetMapping("/account/getTransfers/{account}")
    List<Transfer> getTransfers(@PathVariable("account") long account );


    // Fallback method for updateAccount
    default Account fallbackMethodForUpdateAccount(Account account, Throwable throwable) {
    	// TODO Auto-generated method stub
    	return null;
    }
   
    default Account fallbackMethodForGetAccountDetails(long account, Throwable throwable) {
    	// TODO Auto-generated method stub
    	Account defaultAccount = new Account();
	    defaultAccount.setAccno(4444);
	    defaultAccount.setUsername("kathir");
	    defaultAccount.setId(0);
	    defaultAccount.setBalance(4000);
	    return defaultAccount;
    }

    // Fallback method for getPrimaryDetails
    default Account fallbackMethodForGetPrimaryDetails(String username, Throwable throwable) {
    	Account primaryAccount = new Account();
	    primaryAccount.setAccno(4445);
	    primaryAccount.setUsername("kathir");
	    primaryAccount.setId(0);
	    primaryAccount.setBalance(4000);
	    return primaryAccount;
    }

    // Fallback method for getSavingDetails
    default Saccount fallbackMethodForGetSavingDetails(String username, Throwable throwable) {
    	Saccount savingAccount = new Saccount();
	    savingAccount.setAccno(4446);
	    savingAccount.setUsername("kathir");
	    savingAccount.setId(0);
	    savingAccount.setBalance(4000);
	    return savingAccount;
    }

    // Fallback method for deposit
    default DepositResponse fallbackMethodForDeposit(TransactionDetails details, Throwable throwable) {
    	DepositResponse response = new DepositResponse();
	    response.setAccount(4444);
	    response.setDepositStatus(true);
	    response.setResponseMessage("Deposit successful");
	    return response;
    }

    // Fallback method for withdraw
    default WithdrawResponse fallbackMethodForWithdraw(TransactionDetails details, Throwable throwable) {
    	// Return a default WithdrawResponse indicating success
	    WithdrawResponse response = new WithdrawResponse();
	    response.setAccount(4444);
	    response.setWithdrawStatus(true);
	    response.setResponseMessage("Withdrawal successful");
	    return response;
    }

    default TransferResponse fallbackMethodForTransfer(TransferDetails details, Throwable throwable) {
	    TransferResponse response = new TransferResponse();
	    response.setTransferStatus(true);
	    response.setSaccount(4445);
	    response.setResponseMessage("Transfer successful");
	    return response;
    }


    default List<UserHistory> fallbackMethodForGetAccountHistory(long account, Throwable throwable) {

        return Collections.emptyList(); 
    }

    default List<Transfer> fallbackMethodForGetTransfers(long account, Throwable throwable) {
        return Collections.emptyList(); 
    }
}
