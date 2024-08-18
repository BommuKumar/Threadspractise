package com.naresh.Database.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.Database.Dto.OrderDto;
import com.naresh.Database.Entity.Inventory;
import com.naresh.Database.Entity.Order;
import com.naresh.Database.Entity.User;
import com.naresh.Database.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public String placeOrder(OrderDto orderDto) throws InterruptedException  {
 
		boolean isProductUpdated=productService.isProductUpdated(orderDto.getProductId(), orderDto.getQuantity());
		
		if(isProductUpdated)
		{
			Order order=new Order();
			order.setOrderDate(LocalDate.now());
			order.setQuantity(orderDto.getQuantity());
			order.setStatus("placed");
			order.setUser(new User(orderDto.getUserId()));
			order.setInventory(new Inventory(orderDto.getProductId()));
		    Order placedOrder= orderRepository.save(order);	
		  
		   return "order placed sucessfully with orderId"+placedOrder.getOrderId();
		}
		else
		{
		   return "we are unable to place order at this moment. please try again";
		}
	}

	@Override
	public String placeBulkOrder(List<OrderDto> orderDto) throws InterruptedException {
	  
		
	 
		Runnable  task1 =()->{
		
			  int count=0;
			  
			  for(int i=0;i<orderDto.size()/2;i++)
			  {
			  System.out.println("inside t1("+i+")");
				  
			 
				try {
					placeOrder(orderDto.get(i));
				} catch (InterruptedException ex) {
					 
					  throw new RuntimeException(ex);
				}
		 
			   }
			
			  count++;
			   
		};
		
		
		Runnable  task2 =()->{
			
			  int count=0;
			  
			  for(int i=orderDto.size()/2;i<orderDto.size();i++)
			  {
			   System.out.println("inside t2("+i+")");
				  
				try {
					placeOrder(orderDto.get(i));
				} catch (InterruptedException e) {
					 throw new RuntimeException(e);
 				};

			
			   count++;
			  }
		};
		 Thread t1= new Thread(task1);
		 Thread t2= new Thread(task2);
		 
		 t1.start();
		
		 t2.start();
		
		 t1.join();
		 
		 t2.join();
		 
		 return "all orders are placed successfully";
		
		}
		 
 		 
}
