package com.icinbank.proxy;


import com.icinbank.model.Loan;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "online-banking") 
public interface LoanServiceProxy {

    @Retry(name = "online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetAllLoans")
    @GetMapping("/loans")
    List<Loan> getAllLoans();

    @Retry(name = "online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetLoan")
    @GetMapping("/loans/{id}")
    Loan getLoan(@PathVariable Integer id);

    @Retry(name = "online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForAddLoan")
    @PostMapping("/loans/{userId}")
    Loan addLoan(@RequestBody Loan loan, @PathVariable Integer userId);

    @Retry(name = "online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForUpdateLoan")
    @PutMapping("/loans/{id}")
    Loan updateLoan(@PathVariable Integer id, @RequestBody Loan loan);

    @Retry(name = "online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForDeleteLoan")
    @DeleteMapping("/loans/{id}")
    void deleteLoan(@PathVariable Integer id);

  

    default List<Loan> fallbackMethodForGetAllLoans(Throwable throwable) {
        return Collections.emptyList(); // Return an empty list
    }

    default Loan fallbackMethodForGetLoan(Integer id, Throwable throwable) {
        Loan fallbackLoan = new Loan();
        fallbackLoan.setId(0); // Set some default values for the Loan object
        return fallbackLoan;
    }

    default Loan fallbackMethodForAddLoan(Loan loan, Integer userId, Throwable throwable) {
        Loan fallbackLoan = new Loan();
        fallbackLoan.setId(0); // Set some default values for the Loan object
        return fallbackLoan;
    }

    default Loan fallbackMethodForUpdateLoan(Integer id, Loan loan, Throwable throwable) {
        Loan fallbackLoan = new Loan();
        fallbackLoan.setId(0); // Set some default values for the Loan object
        return fallbackLoan;
    }

    default void fallbackMethodForDeleteLoan(Integer id, Throwable throwable) {
        System.err.println("Fallback: Failed to delete Loan with ID: " + id);
    }
}
