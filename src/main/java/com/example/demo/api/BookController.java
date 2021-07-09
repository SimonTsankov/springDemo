package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("Dope!");

    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody Book book) {
        if (book.getId() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Pich");
        }
        bookRepository.save(book);
        return ResponseEntity.ok("Updated!");
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(bookRepository.findAll());
    }
    @GetMapping(value = "/likename")
    public ResponseEntity<?>likeName(@RequestParam(value ="name") String name){
        List<Book> bookList = bookRepository.findByNameContaining(name);
        return  ResponseEntity.ok().body(bookList);
    }
    @GetMapping(value = "/findByName")
    public ResponseEntity<?> findByName(
            @RequestParam(value = "name") String name
    ) {
        List<Book> bookList = bookRepository.findByName(name);
        return ResponseEntity.ok().body(bookList);
    }

}
