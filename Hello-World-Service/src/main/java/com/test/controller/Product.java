package com.test.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String productName;
	private String desc;

	public Product() {
	
	}

	public Product(int id, String productName, String desc) {
		super();
		this.id = id;
		this.productName = productName;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", desc=" + desc + "]";
	}

}
