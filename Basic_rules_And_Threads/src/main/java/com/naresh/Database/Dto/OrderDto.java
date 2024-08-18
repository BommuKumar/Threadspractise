package com.naresh.Database.Dto;

public class OrderDto {
	
	
   private String productId;
	
	private int quantity;
	
	private String userId;
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

 
	public OrderDto(String productId, int quantity, String userId) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.userId = userId;
	}

	public OrderDto() {
		super();
	}

	 
	@Override
	public String toString() {
		return "OrderDto [productId=" + productId + ", quantity=" + quantity + ", userId=" + userId + "]";
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
 

}
