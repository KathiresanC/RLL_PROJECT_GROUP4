package com.icinbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.model.Loan;
import com.icinbank.model.User;
import com.icinbank.service.LoanService;

@RestController
@RequestMapping("/loans")
// @CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping()
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable Integer id) {
        return loanService.getLoan(id);
    }

    @PostMapping("/{userId}")
    public Loan addLoan(@RequestBody Loan loan, @PathVariable Integer userId) {
        User referenceUser = new User();
        referenceUser.setId(userId);
        loan.setUser(referenceUser);
        return loanService.addLoan(loan);
    }

    @PutMapping("/{id}")
    public Loan updateLoan(@PathVariable Integer id, @RequestBody Loan loan) {
        return loanService.updateLoan(id, loan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Integer id) {
        loanService.deleteLoan(id);
    }

}
