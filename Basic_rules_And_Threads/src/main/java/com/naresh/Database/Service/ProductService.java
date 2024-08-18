package com.naresh.Database.Service;

public interface ProductService {
	
	public boolean isProductUpdated(String productId,int quantity) throws InterruptedException;

}
