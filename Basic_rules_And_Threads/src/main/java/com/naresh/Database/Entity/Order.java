package com.naresh.Database.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="Orders9")
public class Order {
	
	@Id
	
	@SequenceGenerator(name="order9_seq_gen",sequenceName = "order9_seq",allocationSize = 1)
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order9_seq_gen")
	  private int orderId;
	  
	   
	  
	  private int quantity;
	  
	  private String status;
	  
	  private  LocalDate orderDate;
	  
	  @ManyToOne
	  @JoinColumn(name="user_id")
	  @JsonIgnore
	  private User user;
	  
	  
	   @ManyToOne
	   @JoinColumn(name="product_id")
       @JsonIgnore
	  private Inventory inventory;

	  
	  
	  

	 


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Inventory getInventory() {
		return inventory;
	}

 

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	public Order(int orderId, int quantity, String status, LocalDate orderDate, User user, Inventory inventory) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.status = status;
		this.orderDate = orderDate;
		this.user = user;
		this.inventory = inventory;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", status=" + status + ", orderDate="
				+ orderDate + ", user=" + user + ", inventory=" + inventory + "]";
	}


	public Order() {
		super();
	}

     
	

}
 