package com.lms.LoanManagement.Controller;


import com.lms.LoanManagement.LoanService.UserService;
import com.lms.LoanManagement.Model.JwtRequest;
import com.lms.LoanManagement.Model.JwtResponse;
import com.lms.LoanManagement.Model.User;
import com.lms.LoanManagement.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AuthorizationController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return generateToken(jwtRequest);
    }


    public JwtResponse generateToken(JwtRequest jwtRequest) throws ServletException {

        String username =jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        String jwtToken;

        String [] role;
        if(username ==null || password ==null)
        {
            throw new ServletException("Please enter valid credentials");
        }



        boolean flag = userService.loginUser(username,password);


        if(!flag)
        {
            throw new ServletException("Invalid credentials");
        }

        else
        {
            Optional<User> user = userRepository.findById(username);
           // role = user.get().getRole();
            role = user.get().getRole();

            jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis()+300000))
                    .signWith(SignatureAlgorithm.HS256, "secret key").compact();

        }
        return new JwtResponse(jwtToken,role);
    }
}
