package com.naresh.Database.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.CustomException.InsufficientStock;
import com.naresh.Database.CustomException.ProductNotFound;
import com.naresh.Database.Entity.Inventory;
import com.naresh.Database.Repository.InventoryRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	InventoryRepository inventoryRepository;
	 
	 private final ReentrantLock lock = new ReentrantLock();

	@Override
	public boolean isProductUpdated(String productId, int quantity) throws InterruptedException {
		
		 //  final Object globalLock = new Object();

	     
		  
		System.out.println("inside update"+Thread.currentThread().getName());
		

		   if(lock.tryLock(2,TimeUnit.SECONDS))	
		   { 
		     try
		     {
		             Inventory product =inventoryRepository.findById(productId).orElseThrow(()->new ProductNotFound("product not found with this id: "+productId));
		
		             if(product.getQuantity()<quantity)
		              {
			           throw new InsufficientStock("stock not avialable for this product"+productId);
		              }
        
			  
				    System.out.println("start of  synchronised block"+Thread.currentThread().getName());

				 
				 	product.setQuantity(product.getQuantity()-quantity);
				   
				    inventoryRepository.save(product);
				
				    System.out.println("end of synchronised block"+Thread.currentThread().getName());
		    }
				   finally
				     {
				     	lock.unlock();
				     }
          }
			   
	 	
		return true;
	} 

}
