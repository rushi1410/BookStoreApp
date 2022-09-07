package com.bridgelabz.bookstorebackend.entity;
import com.bridgelabz.bookstorebackend.dto.UserDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="UserDetails")
public class User {
    @Id
    @GeneratedValue
    private Integer userID;
    private  String firstName;
    private String lastName;
    private String email;
    private String address;



    public User(UserDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.address = dto.getAddress();

    }
    public User(Integer userID, UserDTO dto) {
        this.userID=userID;
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.address = dto.getAddress();

    }
    public User() {
        super();

    }
}
