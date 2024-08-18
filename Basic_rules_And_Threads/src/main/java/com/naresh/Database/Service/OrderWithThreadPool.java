package com.naresh.Database.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.naresh.Database.Dto.OrderDto;

public interface OrderWithThreadPool {
	
	
    public String placeBulkOrders(List<OrderDto> orderDto) throws InterruptedException, ExecutionException;


}
