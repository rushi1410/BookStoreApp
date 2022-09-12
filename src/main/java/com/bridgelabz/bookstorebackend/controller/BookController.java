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
    //Autowired IBookService to inject its dependency here
    @Autowired
    private IBookService bookService;

    //Ability to call api to add Book record
    //localhost:8080/book/add
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody BookDTO bookdto){
        ResponseDTO dto = new ResponseDTO("User added successfully",bookService.addBook(bookdto));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //Ability to call api to get record by id
    //localhost:8080/book/getBook/{id}
    @GetMapping("/getBook/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record get successfully",bookService.getBookRecord(id));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to get record by book name
    //localhost:8080/book/get/{bookName}
    @GetMapping("/get/{bookName}")
    public ResponseEntity<ResponseDTO> getRecordByBookName(@PathVariable String bookName){
        ResponseDTO dto = new ResponseDTO("Record for particular book get successfully",bookService.getRecordByBookName(bookName));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to get all book records
    //localhost:8080/book/getAllBooks
    @GetMapping("/getAllBooks")
    public ResponseEntity<ResponseDTO> getAllBookRecords() {
        ResponseDTO dto = new ResponseDTO("All Book records get successfully", bookService.getAllBookRecords());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //Ability to call api to update book record by id
    //localhost:8080/book/updateBook/{id}
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<ResponseDTO> updateBookRecord(@PathVariable Integer id,@Valid @RequestBody BookDTO bookdto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully",bookService.updateBookRecord(id,bookdto));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }

    //Ability to call api to sort book records in ascending order
    //localhost:8080/book/sortAsc
    @GetMapping("/sortAsc")
    public ResponseEntity<ResponseDTO> sortRecordAsc() {
        ResponseDTO dto = new ResponseDTO("Records for book sorted in ascending order successfully",bookService.sortRecordAsc());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //Ability to call api to sort book records in descending order
    //localhost:8080/book/sortDesc
    @GetMapping("/sortDesc")
    public ResponseEntity<ResponseDTO> sortRecordDesc() {
        ResponseDTO dto = new ResponseDTO("Records for book sorted in descending order successfully",bookService.sortRecordDesc());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    ///Ability to call api to update quantity of books by id
    //localhost:8080/book/updateQuantity/{id}
    @PutMapping("/updateQuantity/{id}")
    public ResponseEntity<ResponseDTO> updateQuantity(@PathVariable Integer id,@RequestParam Integer quantity){
        ResponseDTO dto = new ResponseDTO("Quantity for book record updated successfully",bookService.updateQuantity(id,quantity));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to delete book record by id
    //localhost:8080/book/deleteBook/{id}
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<ResponseDTO> deleteBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record deleted successfully",bookService.deleteBookRecord(id));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }

}
