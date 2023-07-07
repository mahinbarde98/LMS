package com.lms.LoanManagement.LoanService;

import com.lms.LoanManagement.Model.Loan;
import com.lms.LoanManagement.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;

    public LoanServiceImpl(LoanRepository loanRepository) {
    }

    @Override
    public Loan newLoan(Loan loan) {


        if(loan!=null){
          return   repository.saveAndFlush(loan);
        }
        return null;
    }

    @Override
    public boolean approveLoan(Loan loan) {
       Loan loan1= repository.findById(loan.getLoan_Id()).get();
       if(loan1!=null){
           if(loan1.getStatus().equals("Pending")){
               loan1.setStatus("Approved");

               repository.saveAndFlush(loan1);
               return true;
           }

       }
        return false;
    }

    @Override
    public boolean rejectLoan(Loan loan) {
        Optional<Loan> loan1 = repository.findById(loan.getLoan_Id());
        if (loan1.isPresent()) {
            //repository.deleteById(loan1.get().getLoan_Id());
            if (loan1.get().getStatus() == "Pending") {
                loan1.get().setStatus("Rejected");
                repository.saveAndFlush(loan1.get());

                return true;
            }

        }
        return false;
    }
}
