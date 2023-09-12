package com.icinbank.controller;

import com.icinbank.model.Loan;
import com.icinbank.proxy.LoanServiceProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/online-banking")
public class LoanController {

    private final LoanServiceProxy loanServiceProxy;
    
    private Logger log = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    public LoanController(LoanServiceProxy loanServiceProxy) {
        this.loanServiceProxy = loanServiceProxy;
    }

    @GetMapping("/loan/all")
    public List<Loan> getAllLoans() {
    	List<Loan> lo=loanServiceProxy.getAllLoans();
    	log.debug("The Loan Details ===>"+lo);
        return lo;
    }

    @GetMapping("/loan/{id}")
    public Loan getLoan(@PathVariable Integer id) {
    	Loan lo=loanServiceProxy.getLoan(id);
    	log.debug("The Loan id details ===>"+lo);
        return lo;
    }

    @PostMapping("/{userId}")
    public Loan addLoan(@RequestBody Loan loan, @PathVariable Integer userId) {
    	Loan lo=loanServiceProxy.addLoan(loan, userId);
    	log.debug("The Loan details of user ===>"+lo);
        return lo; 
    }

    @PutMapping("/loan/{id}")
    public Loan updateLoan(@PathVariable Integer id, @RequestBody Loan loan) {
    	Loan lo=loanServiceProxy.updateLoan(id, loan);
    	log.debug("The Loan id details ===>"+lo);
        return lo; 
    }

    @DeleteMapping("/loan/{id}")
    public void deleteLoan(@PathVariable Integer id) {
    	
        loanServiceProxy.deleteLoan(id);
        log.debug("Loan id details deleted.....");
    }
}
