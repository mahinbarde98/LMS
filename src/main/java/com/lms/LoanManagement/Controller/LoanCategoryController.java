package com.lms.LoanManagement.Controller;

import com.lms.LoanManagement.LoanService.LoanCategoryService;
import com.lms.LoanManagement.Model.Loan;
import com.lms.LoanManagement.Model.LoanCategory;
import com.lms.LoanManagement.Repository.LoanCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/lms/")

public class LoanCategoryController {

    @Autowired
    private LoanCategoryService loanCategoryService;
    @Autowired
    private LoanCategoryRepository loanCategoryRepository;

    @PostMapping("addCategory")
    public ResponseEntity<?> createNewLoan(@RequestBody LoanCategory loanCategory){

        if(loanCategory!=null){
            LoanCategory loan1= loanCategoryService.addCategory(loanCategory);

            return new ResponseEntity<String>("New Category created"+loan1.toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Category creation failed",HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @GetMapping("allCategories")
    public List<LoanCategory> allUserLoans(){
        List<LoanCategory> lList = loanCategoryRepository.findAll();
        return lList;
    }
}
