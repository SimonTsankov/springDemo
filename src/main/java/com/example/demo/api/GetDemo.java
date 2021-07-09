package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/get-demo")

public class GetDemo {
    @GetMapping(value = "/hello")
    public ResponseEntity<?> helloWorld() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello въrld");

    }

    @GetMapping(value = "/bye")
    public ResponseEntity<?> byeWorld() {
        return ResponseEntity.status(HttpStatus.OK).body("bye въrld");
    }


}
