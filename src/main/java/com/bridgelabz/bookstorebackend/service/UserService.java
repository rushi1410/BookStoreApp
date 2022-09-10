package com.bridgelabz.bookstorebackend.service;
import com.bridgelabz.bookstorebackend.dto.UserDTO;
import com.bridgelabz.bookstorebackend.entity.User;
import com.bridgelabz.bookstorebackend.exception.BookStoreException;
import com.bridgelabz.bookstorebackend.repository.UserRepository;
import com.bridgelabz.bookstorebackend.util.EmailSenderService;
import com.bridgelabz.bookstorebackend.util.TokenUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    EmailSenderService mailService;
    @Autowired
    TokenUtility utility;

    //Ability to serve controller's insert user record api call
    public String registerUser(UserDTO userdto) {
        User newUser = new User(userdto);
        userRepo.save(newUser);
        String token = utility.createToken(newUser.getUserID());
        mailService.sendEmail(userdto.getEmail(),"Account Sign-up successfully. ","Hello " + newUser.getFirstName() + " Your Account has been created. Your token is " + token + " Keep this token safe to access your account in future. ");
        return token;
    }
    //Ability to serve controller's retrieve user record by token api call
    public User getRecordByToken(String token){
        Integer id = utility.decodeToken(token);
        Optional<User> 	user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        }
        else {
            log.info("Record retrieved successfully for given token having id "+id);
            return user.get();
        }
    }

    public List<User> getAllRecords(){
        List<User> 	userList = userRepo.findAll();
        log.info("All Record get Successfully");
        return userList;
    }
    //Ability to serve controller's retrieve user record by id api call
    public User getRecord(Integer id){
        Optional<User> 	user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        }
        else {
            log.info("Record get successfully for id "+id);
            return user.get();
        }
    }
    public User updateRecord(Integer id, UserDTO dto) {
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        }
        else {
            User newUser = new User(id,dto);
            userRepo.save(newUser);
            log.info("User data updated successfully");
            return newUser;
        }
    }
}
