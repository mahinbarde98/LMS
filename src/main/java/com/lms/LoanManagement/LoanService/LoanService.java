package com.lms.LoanManagement.LoanService;

import com.lms.LoanManagement.Model.Loan;

public interface LoanService {

    public Loan newLoan(Loan loan);

    public boolean approveLoan(Loan loan);

    public boolean rejectLoan(Loan loan);
}
