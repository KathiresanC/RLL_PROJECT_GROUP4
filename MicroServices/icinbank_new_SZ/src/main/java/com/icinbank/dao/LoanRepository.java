package com.icinbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icinbank.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
