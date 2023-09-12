package com.icinbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.dao.LoanRepository;
import com.icinbank.model.Loan;

@Service
public class LoanService {

        @Autowired
        private LoanRepository loanRepository;

        public List<Loan> getAllLoans() {
                List<Loan> loans = new ArrayList<>();
                loanRepository.findAll().forEach(loans::add);
                return loans;
        }

        public Loan getLoan(Integer id) {
                return loanRepository.findById(id).orElseThrow();
        }

        public Loan addLoan(Loan loan) {
                return loanRepository.save(loan);
        }

        public Loan updateLoan(Integer id, Loan modifiedLoan) {

                Loan updatedLoan = null;
                Loan loan = loanRepository.findById(id).orElseThrow();

                if (loan != null) {
                        loan.setLoanStatus(modifiedLoan.getLoanStatus());
                        updatedLoan = loanRepository.save(loan);
                }
                return updatedLoan;
        }

        public void deleteLoan(Integer id) {
                boolean doesLoanExists = loanRepository.existsById(id);
                if (doesLoanExists) {
                        loanRepository.deleteById(id);
                }
        }

}
