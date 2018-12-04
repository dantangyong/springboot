package com.example.demo.respository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  BookRespository  extends JpaRepository<Book,Long> {

  List<Book> findByReader (String reader);
}