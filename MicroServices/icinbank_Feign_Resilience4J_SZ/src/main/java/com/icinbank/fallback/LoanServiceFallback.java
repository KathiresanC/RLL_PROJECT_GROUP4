package com.icinbank.fallback;

import com.icinbank.model.Loan;
import com.icinbank.proxy.LoanServiceProxy;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class LoanServiceFallback implements LoanServiceProxy {

	@Override
	public List<Loan> getAllLoans() {
	    return Collections.emptyList(); // Return an empty list
	}


	@Override
	public Loan getLoan(Integer id) {
	    Loan fallbackLoan = new Loan();
	    fallbackLoan.setId(id); // Set some default values for the Loan object
	    return fallbackLoan;
	}

	@Override
	public Loan addLoan(Loan loan, Integer userId) {
	    Loan fallbackLoan = new Loan();
	    fallbackLoan.setId(0); 
	    return fallbackLoan;
	}

	@Override
	public Loan updateLoan(Integer id, Loan loan) {

	    Loan fallbackLoan = new Loan();
	    fallbackLoan.setId(id); 
	    return fallbackLoan;
	}

	@Override
	public void deleteLoan(Integer id) {
	    System.err.println("Fallback: Failed to delete Loan with ID: " + id);
	}


}
