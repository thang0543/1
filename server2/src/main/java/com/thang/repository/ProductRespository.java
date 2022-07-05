package com.thang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thang.model.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> {

}
