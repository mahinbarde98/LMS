package com.lms.LoanManagement.LoanService;

import com.lms.LoanManagement.Model.Loan;
import com.lms.LoanManagement.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Optional<Loan> findById(int lonId) {
        Optional<Loan> loanList = repository.findById(lonId);
        if(!loanList.isEmpty()){
            return loanList;
        }
        return null;
    }

    @Override
    public Optional<Loan> findByFirstName(String firstName) {
        Optional<Loan> loanList = repository.findByFirstName(firstName);
        if(!loanList.isEmpty()){
            return loanList;
        }


        return Optional.empty();
    }

    @Override
    public Optional<Loan> findByLastName(String lastName) {
        Optional<Loan> loanList = repository.findByLastName(lastName);
        if(!loanList.isEmpty()){
            return loanList;
        }

        return Optional.empty();
    }

    @Override
    public boolean updateLoan(int loanId, Loan loan) {
        Optional<Loan> loan1 = repository.findById(loanId);
        if(!loan1.isEmpty()){
            loan1.get().setFirstName(loan.getFirstName());
            loan1.get().setLastName(loan.getLastName());
            loan1.get().setDuration(loan.getDuration());
            loan1.get().setAddress(loan.getAddress());
            loan1.get().setDuration(loan.getDuration());
            loan1.get().setPhoneNo(loan.getPhoneNo());
            repository.saveAndFlush(loan1.get());
            return true;
        }
        return false;
    }
}
