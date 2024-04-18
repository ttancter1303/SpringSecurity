package com.example.securityspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("product")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>("List product", HttpStatus.OK);
    }
    @PostMapping("product/save")
    public ResponseEntity<?> save(){
        return new ResponseEntity<>("Save product", HttpStatus.OK);
    }
    @GetMapping("register")
    public ResponseEntity<?> register(){
        return new ResponseEntity<>("Register product", HttpStatus.OK);
    }
}
