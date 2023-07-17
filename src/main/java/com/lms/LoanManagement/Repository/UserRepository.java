package com.lms.LoanManagement.Repository;


import com.lms.LoanManagement.Model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value="select u from User u where u.username= :username and u.password= :password")
    public User validateUser(String username, String password);


    boolean findByUsername(String username);
}
