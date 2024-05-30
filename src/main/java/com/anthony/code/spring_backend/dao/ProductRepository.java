package com.anthony.code.spring_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthony.code.spring_backend.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
