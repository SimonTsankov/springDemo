package com.example.demo.api;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Author author) {

        authorRepository.save(author);
        return ResponseEntity.ok("Dope");
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody Author author) {
        if (author.getId() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed PICH");
        }
        authorRepository.save(author);
        return ResponseEntity.ok("Dope!");
    }

    @GetMapping(value = "/findByName")
    public ResponseEntity<?> findByName(@RequestParam(value = "name") String name) {
        List<Author> authorsList = authorRepository.findByName(name);
        return ResponseEntity.ok().body(authorsList);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(authorRepository.findAll());
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id") Long id) {

        if (authorRepository.findById(id) != null) {
            authorRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } else return ResponseEntity.ok("Not deleted");
    }
}
