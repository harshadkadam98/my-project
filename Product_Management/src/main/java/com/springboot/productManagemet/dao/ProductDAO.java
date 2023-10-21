package com.springboot.productManagemet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.springboot.productManagemet.entity.Product;

public interface ProductDAO extends JpaRepository<Product,Integer>{

}
