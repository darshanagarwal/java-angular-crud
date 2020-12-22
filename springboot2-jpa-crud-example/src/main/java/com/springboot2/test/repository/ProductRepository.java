package com.springboot2.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot2.test.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
