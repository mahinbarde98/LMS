package com.lms.LoanManagement.Repository;

import com.lms.LoanManagement.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
    public Optional<Loan> findByFirstName(String firstName);
    public Optional<Loan> findByLastName(String lastName);

}
