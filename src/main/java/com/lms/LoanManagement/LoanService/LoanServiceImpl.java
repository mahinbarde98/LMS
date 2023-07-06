package com.lms.LoanManagement.LoanService;

import com.lms.LoanManagement.Model.Loan;
import com.lms.LoanManagement.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;

    @Override
    public Loan newLoan(Loan loan) {


        if(loan!=null){
          return   repository.saveAndFlush(loan);
        }
        return null;
    }
}
