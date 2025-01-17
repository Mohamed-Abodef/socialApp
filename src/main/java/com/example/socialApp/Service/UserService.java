package com.example.socialApp.Service;

import com.example.socialApp.Repository.UserRepo;
import com.example.socialApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users saveUser(Users user){
        /*
        * Create new users
        * write here your conditions
        */
        return userRepo.save(user);
    }


}
