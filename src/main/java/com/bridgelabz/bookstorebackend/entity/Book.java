package com.bridgelabz.bookstorebackend.entity;


import com.bridgelabz.bookstorebackend.dto.BookDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue
    private Integer bookID;
    private String bookName;
    private String authorName;
    private String bookDescription;
    private String bookImg;
    private Integer price;
    private Integer quantity;

    public Book(BookDTO dto) {
        super();
        this.bookName = dto.getBookName();
        this.authorName = dto.getAuthorName();
        this.bookDescription = dto.getBookDescription();
        this.bookImg = dto.getBookImg();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
    }
    public Book(Integer bookID,BookDTO dto) {
        super();
        this.bookID = bookID;
        this.bookName = dto.getBookName();
        this.authorName = dto.getAuthorName();
        this.bookDescription = dto.getBookDescription();
        this.bookImg = dto.getBookImg();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
    }
    public Book() {

        super();
    }
}
