package com.naresh.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.CustomException.InsufficientStock;
import com.naresh.Database.CustomException.ProductNotFound;
import com.naresh.Database.Dto.OrderDto;
import com.naresh.Database.Service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("place/order")
	public ResponseEntity<String>  placeOrder(@RequestBody OrderDto orderDto) 
	{
	 	try
	 	{
		return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(orderDto));
	 	}
	 	catch(ProductNotFound ex)
	 	{
	 		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
	 	}
	 	catch(InsufficientStock ex)
	 	{
	 		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getLocalizedMessage());
	 	}
	 	catch(InterruptedException ex)
	 	{
	 		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getLocalizedMessage());

	 	}
	 	 
  	}
	
	
	@PostMapping("place/bulk/order")
	
	public ResponseEntity<String>  placeBulkOrders(@RequestBody List<OrderDto> orderDto) throws InterruptedException
	{ 
		try
	   {
	   	return ResponseEntity.status(HttpStatus.OK).body(orderService.placeBulkOrder(orderDto));
	   }
		catch(RuntimeException ex)
	 	{
	 		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getLocalizedMessage());
	 	}
	 	catch(InterruptedException ex)
	 	{
	 		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getLocalizedMessage());

	 	}
  	} 
	 
}
