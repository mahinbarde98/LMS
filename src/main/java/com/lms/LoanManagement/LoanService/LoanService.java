package com.lms.LoanManagement.LoanService;

import com.lms.LoanManagement.Model.Loan;

import java.util.Optional;

public interface LoanService {

    public Loan newLoan(Loan loan);

    public boolean approveLoan(Loan loan);

    public boolean rejectLoan(Loan loan);

    public Optional<Loan> findById(int lonId);

    public Optional<Loan> findByFirstName(String firstName);

    public Optional<Loan> findByLastName(String lastName);

    public boolean updateLoan(int loanID,Loan loan);
}
