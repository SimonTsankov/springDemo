package com.example.demo.api;

import com.example.demo.model.Address;
import com.example.demo.model.Author;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Address adress) {
        addressRepository.save(adress);
        return ResponseEntity.ok("Dope");
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody Address address) {
        if (address.getId() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed PICH");
        }
        addressRepository.save(address);
        return ResponseEntity.ok("Dope!");
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(addressRepository.findAll());
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id") Long id) {

        if (addressRepository.findById(id) != null) {
            addressRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } else return ResponseEntity.ok("Not deleted");
    }
}
