package com.bridgelabz.bookstorebackend.repository;
import com.bridgelabz.bookstorebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;;
public interface UserRepository extends JpaRepository<User, Integer>{
}
