package com.example.demo.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private String contact;
	private String status;
	private Long price;
	private Long total;
	
	public Product() {}

	public Product(int id, String name, String address, String contact, String status, Long price, Long total) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.status = status;
		this.price = price;
		this.total = total;
	}

	@Override
	public String toString() {
		return "model [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", status="
				+ status + ", price=" + price + ", total=" + total + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
