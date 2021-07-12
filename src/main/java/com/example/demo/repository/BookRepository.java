package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByName(String name);
    List<Book> findByOrderByIdAsc();
    List<Book> findByNameContaining(String name);
    List<Book> findByGenreContaining(String genre);
    List<Book> findBookByAuthor_NameContaining(String name);
}
