package com.bridgelabz.bookstorebackend.service;
import com.bridgelabz.bookstorebackend.dto.UserDTO;
import com.bridgelabz.bookstorebackend.entity.User;

import java.util.List;
public interface IUserService {
  public User registerUser(UserDTO userDTO);
    public List<User> getAllRecords();

    public User getRecord(Integer id);

    public User updateRecord(Integer id, UserDTO dto);
}

