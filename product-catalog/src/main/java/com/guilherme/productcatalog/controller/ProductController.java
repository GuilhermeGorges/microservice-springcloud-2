package com.guilherme.productcatalog.controller;

import com.guilherme.productcatalog.model.Product;
import com.guilherme.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<Product> findById(@PathVariable("id") Integer id) {
        return productRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> listAll() {
        return productRepository.findAll();
    }
}
