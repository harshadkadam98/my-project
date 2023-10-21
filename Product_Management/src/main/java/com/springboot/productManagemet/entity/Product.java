package com.springboot.productManagemet.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="product")
public class Product {

	@Id
	@Column(name="product_id")
	private int product_id;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private float price;
	@Column(name="inStoke")
	private String inStoke;
	@Column(name="quantityInStoke")
	private int quantityInStoke;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int product_id, String name, float price, String inStoke, int quantityInStoke) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.inStoke = inStoke;
		this.quantityInStoke = quantityInStoke;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getInStoke() {
		return inStoke;
	}

	public void setInStoke(String inStoke) {
		this.inStoke = inStoke;
	}

	public int getQuantityInStoke() {
		return quantityInStoke;
	}

	public void setQuantityInStoke(int quantityInStoke) {
		this.quantityInStoke = quantityInStoke;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(product_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return product_id == other.product_id;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", price=" + price + ", inStoke=" + inStoke
				+ ", quantityInStoke=" + quantityInStoke + "]";
	}

	
}
