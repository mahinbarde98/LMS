package com.lms.LoanManagement.LoanService;


import com.lms.LoanManagement.Model.User;

public interface UserService {
     public User addUser(User user);
     public boolean loginUser(String username, String password);// login
     public User createNewUser(User user);
     public User resetPassword(User user);
}
