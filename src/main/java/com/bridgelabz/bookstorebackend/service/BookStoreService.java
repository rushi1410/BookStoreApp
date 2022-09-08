package com.bridgelabz.bookstorebackend.service;


import com.bridgelabz.bookstorebackend.dto.BookDTO;
import com.bridgelabz.bookstorebackend.entity.Book;
import com.bridgelabz.bookstorebackend.exception.BookStoreException;
import com.bridgelabz.bookstorebackend.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookStoreService implements IBookService {
    @Autowired
    private BookRepository bookRepo;
    public Book addBook(BookDTO bookdto) {
        Book newBook = new Book(bookdto);
        bookRepo.save(newBook);
        log.info("Book record added successfully");
        return newBook;
    }
    public List<Book> getAllBookRecords(){
        List<Book> 	bookList =bookRepo.findAll();
        log.info("All book records get successfully");
        return bookList;
    }
    //Ability to serve to controller's retrieving all records api call
    public List<Book> getBookRecord(Integer id) {
        List<Book> book = bookRepo.findByBookId(id);
        if(book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        }
        else {
            log.info("Book record get successfully for id "+id);
            return book;
        }
    }
    //Ability to serve to controller's update record by id api call
    public Book updateBookRecord(Integer id,BookDTO dto) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        }
        else {
            Book newBook = new Book(id,dto);
            bookRepo.save(newBook);
            log.info("Book record updated successfully for id "+id);
            return newBook;
        }

    }
    public List<Book> getRecordByBookName(String bookName) {
        List<Book> book = bookRepo.findByBookName(bookName);
        if(book.isEmpty()) {
            throw new BookStoreException("Book doesn't exists");
        }
        else {
            log.info("Book record get successfully for Book Name : "+bookName);
            return book;
        }
    }
    //Ability to serve to controller's delete record api call
    public Book deleteBookRecord(Integer id) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        }
        else {
            bookRepo.deleteById(id);
            log.info("Book record deleted successfully for id "+id);
            return book.get();
        }
    }
}