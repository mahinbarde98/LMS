package com.lms.LoanManagement.Controller;

import com.lms.LoanManagement.LoanService.LoanService;
import com.lms.LoanManagement.Model.Loan;
import com.lms.LoanManagement.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lms/")
public class LoanController {

    @Autowired
    private LoanService loanService;
    @Autowired
    private LoanRepository loanRepository;

    @PostMapping("addLoan")
    public ResponseEntity<?> createNewLoan(@RequestBody Loan loan){

        if(loan!=null){
           Loan loan1= loanService.newLoan(loan);

            return new ResponseEntity<String>("Loan succesfully created"+loan1.getLoan_Id(), HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Loan creation failed",HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("all")
    public List<Loan> allUserLoans(){
        List<Loan> lList = loanRepository.findAll();
        return lList;
    }
}
