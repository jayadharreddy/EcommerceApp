package com.project.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
