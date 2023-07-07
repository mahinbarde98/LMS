//package com.lms.LoanManagement.LoanService;
//
//import com.lms.LoanManagement.Model.Loan;
//import com.lms.LoanManagement.Repository.LoanRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//class LoanServiceImplTest {
//
//    @Autowired
//    private LoanRepository loanRepository;
//
////    @Autowired
//    private LoanServiceImpl loanService;
//
////    @BeforeEach
////    void setup() {
////        this.loanService = new LoanServiceImpl(loanRepository);
////    }
//    @Test
//    void newLoan() {
//
//        Loan loan =
//                new Loan(1,"Home Loan",25000,2.5f,"Pune Municipal Party","Job","Mahesh","Barde","mahesh@gmail.com",1234567890);
//       loanService.newLoan(loan);
//        verify(loanRepository).saveAndFlush(loan);
////        assertThat(1).isEqualTo(loan1.getLoan_Id());
//
//    }
//
//    @AfterEach
//    void tearDown() {
//
//    }
//}