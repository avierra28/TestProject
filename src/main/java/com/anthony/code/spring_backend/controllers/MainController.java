package com.anthony.code.spring_backend.controllers;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.code.spring_backend.dao.ProductRepository;
import com.anthony.code.spring_backend.entities.Products;

import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {

    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/products")
    public ArrayList<Products> getAllProducts() {

        return (ArrayList<Products>) productRepository.findAll();
    }

    @GetMapping(path = "/products/{id}")
    public Products getProduct(@PathVariable Long id) {

        return productRepository.findById(id).get();
    }

    @PostMapping(path = "/products")
    public void createProduct(@RequestBody Products products) {

        productRepository.save(products);
    }

    @PutMapping(path = "/products")
    public void updateProduct(@RequestBody Products products) {

        productRepository.save(products);
    }
}
