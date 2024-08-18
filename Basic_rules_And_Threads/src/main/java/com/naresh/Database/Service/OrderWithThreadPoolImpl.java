package com.naresh.Database.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Dto.OrderDto;

 @Service

public class OrderWithThreadPoolImpl implements OrderWithThreadPool{

	 @Autowired
	OrderService orderService;
	
    ExecutorService executorService = Executors.newFixedThreadPool(3);
	
    public String placeBulkOrders(List<OrderDto> orderDto) throws InterruptedException, ExecutionException
    {
    
	    Runnable task1=()->{
	    	
	    	 for(int i=0;i<orderDto.size()/2;i++) { // here i=0,i=1 executes sequtially only
	    	                                         // but task1 executes concurently with mainthread
	    	try {
	    		
	    		System.out.println("inside task1"+Thread.currentThread().getName());
				orderService.placeOrder(orderDto.get(0));
			} catch (InterruptedException e) {


				e.printStackTrace();
			}
	    }
	    };
	    
     Runnable task2=()->{      
	    	
    	 for(int i=orderDto.size()/2;i<orderDto.size();i++)  // here i=2,i=3 executes sequtially only
    		                                                 // but task2 executes concurently with mainthread
    	 {
	    	try {
	    		
	    		System.out.println("inside task2 "+Thread.currentThread().getName());

				orderService.placeOrder(orderDto.get(1));
			} catch (InterruptedException e) {


				e.printStackTrace();
			}
    	 }
	    };
	    
	    Runnable task3=()->{
	    	
	    	 for(int i=0;i<orderDto.size()/2;i++) { // here i=0,i=1 executes sequtially only
	    	                                         // but task1 executes concurently with mainthread
	    	try {
	    		
	    		System.out.println("inside task1"+Thread.currentThread().getName());
				orderService.placeOrder(orderDto.get(0));
			} catch (InterruptedException e) {


				e.printStackTrace();
			}
	    }
	    };
	    
	   Future<?> future1= executorService.submit(task1)  ; 
	   
	   Future<?> future2= executorService.submit(task2)  ; 
	   
	   Future<?> future3= executorService.submit(task3)  ; 
	    
	      
	    executorService.shutdown();
	    
	    future1.get();
	    
	    future2.get();
	    
	    future3.get();
	    
	    
		return "all orders placed sucessfully";
      
    }
 
	 
	
	
}
