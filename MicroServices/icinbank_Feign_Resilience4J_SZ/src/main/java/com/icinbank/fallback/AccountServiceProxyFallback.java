package com.icinbank.fallback;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

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

@Component
public class AccountServiceProxyFallback implements AccountServiceProxy {

	@Override
	public Account getAccountDetails(long account) {
	    // Return a default Account object with some placeholder values
	    Account defaultAccount = new Account();
	    defaultAccount.setAccno(4444);
	    defaultAccount.setUsername("kathir");
	    defaultAccount.setId(0);
	    defaultAccount.setBalance(4000);
	    return defaultAccount;
	}

	@Override
	public Account getPrimaryDetails(String username) {
	    // Return a default Account object for primary account
	    Account primaryAccount = new Account();
	    primaryAccount.setAccno(4445);
	    primaryAccount.setUsername("kathir");
	    primaryAccount.setId(0);
	    primaryAccount.setBalance(4000);
	    return primaryAccount;
	}

	@Override
	public Saccount getSavingDetails(String username) {
	    // Return a default Saccount object for saving account
	    Saccount savingAccount = new Saccount();
	    savingAccount.setAccno(4446);
	    savingAccount.setUsername("kathir");
	    savingAccount.setId(0);
	    savingAccount.setBalance(4000);
	    return savingAccount;
	}

	@Override
	public DepositResponse deposit(TransactionDetails details) {
	    // Return a default DepositResponse indicating success
	    DepositResponse response = new DepositResponse();
	    response.setAccount(4444);
	    response.setDepositStatus(true);
	    response.setResponseMessage("Deposit successful");
	    return response;
	}

	@Override
	public WithdrawResponse withdraw(TransactionDetails details) {
	    // Return a default WithdrawResponse indicating success
	    WithdrawResponse response = new WithdrawResponse();
	    response.setAccount(4444);
	    response.setWithdrawStatus(true);
	    response.setResponseMessage("Withdrawal successful");
	    return response;
	}

	@Override
	public TransferResponse transfer(TransferDetails details) {
	    // Return a default TransferResponse indicating success
	    TransferResponse response = new TransferResponse();
	    response.setTransferStatus(true);
	    response.setSaccount(4445);
	    response.setResponseMessage("Transfer successful");
	    return response;
	}

	@Override
	public List<UserHistory> getAccountHistory(long account) {
	    // Return an empty list when the history is not available
	    return Collections.emptyList();
	}

	@Override
	public List<Transfer> getTransfers(long account) {
	    // Return an empty list when transfer history is not available
	    return Collections.emptyList();
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

}
