package com.bridgelabz.bookstorebackend.controller;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.dto.UserDTO;
import com.bridgelabz.bookstorebackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //localhost:8080/user/add
    @PostMapping("/add")
    public ResponseEntity<String> saveDataToRepo(@Valid @RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO("User Record created successfully", userService.saveDataToRepo(userDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
    //localhost:8080/user/getAll
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllRecords(){
        ResponseDTO dto = new ResponseDTO("All records get successfully",userService.getAllRecords());
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    //Ability to call api to get user record by id
    //localhost:8080/user/get/{id}
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record get successfully",userService.getRecord(id));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    //localhost:8080/user/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateRecord(@PathVariable Integer id, @Valid @RequestBody UserDTO userdto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully",userService.updateRecord(id,userdto));
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }
}
