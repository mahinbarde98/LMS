package com.lms.LoanManagement.LoanService;

import com.lms.LoanManagement.Model.LoanCategory;
import com.lms.LoanManagement.Repository.LoanCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanCategoryImpl implements LoanCategoryService{
    @Autowired
    LoanCategoryRepository repository;

    @Override
    public LoanCategory addCategory(LoanCategory loanCategory) {
        if(loanCategory!=null){
            return repository.saveAndFlush(loanCategory);
        }
        return null;
    }
}
