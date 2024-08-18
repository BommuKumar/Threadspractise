package com.naresh.Database.Service;

import java.util.List;

import com.naresh.Database.Dto.OrderDto;

public interface OrderService {
	
	public String placeOrder(OrderDto orderDto)throws InterruptedException;
	
	public String placeBulkOrder(List<OrderDto> orderDto) throws InterruptedException;	

}
