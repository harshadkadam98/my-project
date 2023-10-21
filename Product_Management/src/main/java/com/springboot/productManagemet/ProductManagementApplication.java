package com.springboot.productManagemet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.productManagemet.dao.MyUserDao;
import com.springboot.productManagemet.dao.ProductDAO;
import com.springboot.productManagemet.entity.MyUser;
//import com.springboot.productManagemet.entity.Product;

@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(ProductManagementApplication.class, args);
		ProductDAO dao = (ProductDAO)context.getBean("productDAO");
		MyUserDao dao1=(MyUserDao)context.getBean("myUserDao");
		dao1.save(new MyUser(1,"harsh","123","ROLE_USER"));
		//dao.save(new Product(5,"Qled tv",15000,"yes",20));

	}

}
