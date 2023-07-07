package com.lms.LoanManagement.Model;

import jakarta.persistence.*;
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
    @Column(unique = true)
    private String emailId;
    private long phoneNo;

    private String status="Pending";//pending,approved , rejected

}
