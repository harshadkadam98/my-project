package com.springboot.productManagemet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.productManagemet.dao.ProductDAO;
import com.springboot.productManagemet.entity.Product;

@RestController
@RequestMapping("/user")
public class ProductController {

	@Autowired
	private ProductDAO dao ;
	
	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/products")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Product> getAllProducts()
	{
		List<Product> product=dao.findAll();
		System.out.println("productSize" +product.size());
		return product;
	}
	
	@GetMapping(path ="/product/{product_id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProduct(@PathVariable("product_id")int product_id) {
		Product product=dao.findById(product_id).orElse(new Product());
		return product;
	}
	
	@PostMapping("/insertproduct")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product addProduct(@RequestBody Product product) {
		System.out.println("productSize" +product);
		dao.save(product);
		return product;
	}
	
	@PostMapping(path="/productt",consumes= {"application/json"})
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void addProducts(@RequestBody Product product) {
		dao.save(product);
	}
	
	@DeleteMapping("/product/{product_id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void deleteProduct(@PathVariable int product_id) {
		dao.deleteById(product_id);
	}
	
	@PutMapping("/product")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public void addOrUpdate(@RequestBody Product product) {
		dao.save(product);
	}
	
}
