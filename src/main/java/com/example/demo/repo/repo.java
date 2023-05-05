package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Product.Product;

public interface repo extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
}
