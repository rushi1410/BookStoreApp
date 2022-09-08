package com.bridgelabz.bookstorebackend.controller;

import com.bridgelabz.bookstorebackend.dto.BookDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//Controller class to make api calls
@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    //localhost:8080/book/add
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody BookDTO bookdto){
        ResponseDTO dto = new ResponseDTO("Book added successfully",bookService.addBook(bookdto));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //localhost:8080/book/getBook/{id}
    @GetMapping("/getBook/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record get successfully",bookService.getBookRecord(id));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //localhost:8080/book/updateBook/{id}
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<ResponseDTO> updateBookRecord(@PathVariable Integer id,@Valid @RequestBody BookDTO bookdto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully",bookService.updateBookRecord(id,bookdto));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }
    //localhost:8080/book/deleteBook/{id}
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<ResponseDTO> deleteBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record deleted successfully",bookService.deleteBookRecord(id));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }

}
