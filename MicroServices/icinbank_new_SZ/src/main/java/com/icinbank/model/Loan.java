package com.icinbank.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int amount;
    private String annualIncome;
    private String loanUsedFor;
    @Column(columnDefinition = "varchar(10) default 'Pending'")
    private String loanStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Loan(int amount, String annualIncome, String loanUsedFor, int userId) {
        this.amount = amount;
        this.annualIncome = annualIncome;
        this.loanUsedFor = loanUsedFor;
        User referenceUser = new User();

        referenceUser.setId(userId);
        this.user = referenceUser;
    }

    public Loan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getLoanUsedFor() {
        return loanUsedFor;
    }

    public void setLoanUsedFor(String loanUsedFor) {
        this.loanUsedFor = loanUsedFor;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
