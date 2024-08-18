package com.naresh.Database.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="Inventory9")
public class Inventory {
	
	@Id
	private String productId;
	
	private int  quantity;
	
	private String productName;
	
	
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory")
	 private  List<Order> order;
	 
	 
	 

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	 

	public Inventory(String productId, int quantity, String productName, List<Order> order) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.productName = productName;
		this.order = order;
	}

	public Inventory() {
		super();
	}

	public Inventory(String productId) {
		super();
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Inventory [productId=" + productId + ", quantity=" + quantity + ", productName=" + productName
				+ ", order=" + order + "]";
	}

	 
	 
 

	 
	
	 
}
 