package com.lms.LoanManagement.Repository;

import com.lms.LoanManagement.Model.LoanCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanCategoryRepository extends JpaRepository<LoanCategory,String> {
}
