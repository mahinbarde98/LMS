package com.lms.LoanManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loan_Id;
    private String loanCategory;
    private long loanAmount;
    private float duration;
    private String address;
    private String occupation;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNo;


}
