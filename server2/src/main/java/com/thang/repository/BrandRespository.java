package com.thang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thang.model.entity.Brand;

public interface BrandRespository extends  JpaRepository<Brand, Integer>{

}
