package com.lms.LoanManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class User {
    @Id
    String username;
    String password;
    String firstName;
    String lastName;
    String secAns;

    String [] role;



}
