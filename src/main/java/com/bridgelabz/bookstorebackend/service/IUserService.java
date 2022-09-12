package com.bridgelabz.bookstorebackend.service;
import com.bridgelabz.bookstorebackend.dto.ChangePasswordDTO;
import com.bridgelabz.bookstorebackend.dto.LoginDTO;
import com.bridgelabz.bookstorebackend.dto.UserDTO;
import com.bridgelabz.bookstorebackend.entity.User;

import java.util.List;
public interface IUserService {
    public String registerUser(UserDTO userdto);
    public List<User> getAllRecords();
    public User getRecord(Integer id);
    public String getToken(String email);
    public User getRecordByToken(String token);
    public User updateRecord(Integer id, UserDTO dto);
    public User userLogin(LoginDTO logindto);
    public User changePassword(ChangePasswordDTO dto);
}

