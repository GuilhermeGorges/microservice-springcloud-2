package com.guilherme.productcatalog.controller;

import com.guilherme.productcatalog.modal.Product;
import com.guilherme.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping(value="/{id}")
    Optional<Product> findById(@PathVariable Integer id){
        return productRepository.findById(id);
    }}
