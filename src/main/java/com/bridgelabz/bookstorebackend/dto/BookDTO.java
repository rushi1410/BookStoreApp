package com.bridgelabz.bookstorebackend.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class BookDTO {
    @NotEmpty(message="Please enter book name")
    private String bookName;

    @NotEmpty(message="Please enter author name")
    private String authorName;

    //@NotEmpty(message="Please enter book description")
    private String bookDescription;

   // @NotEmpty(message="Book image yet to be provided")
    private String bookImg;

    private Integer price;

    private Integer quantity;

}
