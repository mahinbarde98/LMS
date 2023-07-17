package com.lms.LoanManagement.LoanService;


import com.lms.LoanManagement.Model.User;
import com.lms.LoanManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(User user) {
        if(user!=null){
            user.setRole(new String[]{"user"});
            return repository.saveAndFlush(user);
        }
        return null;
    }

    @Override
    public boolean loginUser(String username, String password) {
        User user1 = repository.validateUser(username, password);
        System.out.println("User: "+ user1.getUsername());
        if(user1!=null)
        {
            return true;
        }
        return false;
    }

//    public void init(){
//        Role adminRole = new Role();
//        adminRole.setRole("Admin");
//        roleRepo.save(adminRole);
//
//        Role userRole = new Role();
//        userRole.setRole("User");
//        roleRepo.save(userRole);
//
//        User adminUser =new User();
//        adminUser.setUsername("Admin");
//        adminUser.setPassword("admin");
//        List<Role> role =new ArrayList<>();
//        role.add(adminRole);
//        adminUser.setRole(role);
//        adminUser.setFirstName("admin");
//        adminUser.setLastName("admin");
//
//        repository.save(adminUser);
//
//        User user =new User();
//        user.setUsername("User");
//        user.setPassword("user");
//         List<Role>  role1 =new ArrayList<>();
//        role.add(userRole);
//        user.setRole(role1);
//        user.setFirstName("user");
//        user.setLastName("user");
//        repository.save(user);
//    }
    public void init(){
        User user =new User("admin","admin","admin","admin","Rony", new String[]{"admin"});
    repository.save(user);
        User user2 =new User("user","user","Raj","Malhotra","Rony", new String[]{"user"});
        repository.save(user2);

    }

    @Override
    public User createNewUser(User user){
        User user1 =new User();
        //String [] role ={"user"};
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setSecAns(user.getSecAns());
        user1.setRole(user.getRole());
        return repository.save(user1);

    }

    @Override
    public User resetPassword(User user) {
        Optional<User> user1 = repository.findById(user.getUsername());
        if(user1.isPresent()){
            user1.get().setPassword(user.getPassword());
            return repository.save(user1.get());
        }
        return null;
    }
}
