package com.naresh.Database;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Dto.OrderDto;
import com.naresh.Database.Service.OrderWithThreadPool;

@RestController
@RequestMapping("thread/pool")
public class OrdersThreadPoolController {
	
	@Autowired
	OrderWithThreadPool orderWithThreadPool;
	
	@PostMapping("place/bulk")
	
	public ResponseEntity<String>  placeBulkOrders(@RequestBody List<OrderDto> orderDto) throws InterruptedException, ExecutionException
	{  
	   	return ResponseEntity.status(HttpStatus.OK).body(orderWithThreadPool.placeBulkOrders(orderDto));
	    
		 
  	} 
	 

}
