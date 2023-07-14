package com.lms.LoanManagement.Controller;

import com.lms.LoanManagement.LoanService.LoanService;
import com.lms.LoanManagement.Model.Loan;
import com.lms.LoanManagement.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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

    @PutMapping("approveLoan/{lId}")
    public ResponseEntity<?> approveLoan(@PathVariable ("lId") int lId) {
       Loan loan1 = loanRepository.findById(lId).get();
        if(loan1!=null){

            loanService.approveLoan(loan1);
            return new ResponseEntity<String>("loan approved",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Something missing",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("rejectLoan")
    public ResponseEntity<?> rejectLoan(@RequestBody Loan loan){
        Optional<Loan> loan1 = loanRepository.findById(loan.getLoan_Id());
        if(loan1.isPresent()){
            loanService.rejectLoan(loan1.get());
            return new ResponseEntity<String>("loan rejected",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Something missing",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("findById/{loanId}")
    public ResponseEntity<?> loanById(@PathVariable ("loanId") int loanId){
        Optional<Loan> lList = loanService.findById(loanId);
        if(lList.isPresent()){
            return new ResponseEntity<>(lList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("findByFirstName/{firstName}")
    public ResponseEntity<?> loanByFirstName(@PathVariable ("firstName") String firstName){
        Optional<Loan> lList = loanService.findByFirstName(firstName);
        if(lList.isPresent()){
            return new ResponseEntity<>(lList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("findByLastName/{lastName}")
    public ResponseEntity<?> loanByLastName(@PathVariable ("lastName") String lastName){
        Optional<Loan> lList = loanService.findByLastName(lastName);
        if(lList.isPresent()){
            return new ResponseEntity<>(lList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("updateLoan/{loanId}")
    public ResponseEntity<?> updateLoan(@PathVariable ("loanId") int loanId,@RequestBody Loan loan){
        Optional<Loan> loan1 = loanRepository.findById(loanId);
        if(loan1.isPresent() && loanService.updateLoan(loanId,loan)){

            return new ResponseEntity<String>("loan Updated",HttpStatus.OK);
        }
        return new ResponseEntity<String>("loan not updated",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
