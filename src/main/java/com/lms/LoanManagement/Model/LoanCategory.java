package com.lms.LoanManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoanCategory {
    @Id
    private String category;
    private String catDetails;
    private float interestRate;
}
