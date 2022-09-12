package com.bridgelabz.bookstorebackend.repository;


import com.bridgelabz.bookstorebackend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value="select * from book where bookid =:id",nativeQuery=true)
    public List<Book> findByBookId(Integer id);
    @Query(value="select * from book where book_name LIKE :bookName%",nativeQuery=true)
    public List<Book> findByBookName(String bookName);
    @Query(value="select * from book ORDER BY price",nativeQuery = true)
    public List<Book> sortBooksAsc();
    @Query(value="select * from book ORDER BY price DESC",nativeQuery = true)
    public List<Book> sortBooksDesc();

}
