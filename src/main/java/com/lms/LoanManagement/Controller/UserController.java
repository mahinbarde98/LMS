package com.lms.LoanManagement.Controller;


import com.lms.LoanManagement.LoanService.UserServiceImpl;
import com.lms.LoanManagement.Model.User;
import com.lms.LoanManagement.Repository.UserRepository;
import com.lms.LoanManagement.response.ResponseHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    void initRoleAndUser() {
        userService.init();
    }

    @GetMapping("/alluseres")
    public ResponseEntity<?> viewAllUsers(){
        if(userRepository.findAll()!=null){
            List<User> userList = userRepository.findAll();
            return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
        }

        return new ResponseEntity<String>("No User Present at the time", HttpStatus.NO_CONTENT);
    }

//    public ResponseEntity<?> allUsers(){
//        List<User> users = userRepository.findAll();
//        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
//    }
    @PostMapping("/register")
    public ResponseEntity<?> registerNewuser(@RequestBody User user) {
        //String username = user.getUsername();
        if(user!=null){
            userService.addUser(user);
            return ResponseEntity.ok()
                    .body(ResponseHandler
                            .generateResponse("User successfully created", HttpStatus.OK, user));

        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User Not Created");
    }

    @PutMapping("/reset/{username}")
    public ResponseEntity<?> resetPassword(@PathVariable ("username") String username,@RequestBody  User user)
    {
        String ans  = user.getSecAns();
        Optional<User> user1=userRepository.findById(username);
        if (user1.isPresent() && ans.equals(user1.get().getSecAns())){

            userService.resetPassword(user);
            Optional<User> user2=userRepository.findById(username);
            return ResponseEntity.ok()
                    .body(ResponseHandler
                            .generateResponse("Password successfully changed", HttpStatus.CREATED, user2));
        }
        return  ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("MissMatch Found");
    }
}
