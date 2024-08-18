package com.naresh.Database.CustomException;

public class InsufficientStock extends RuntimeException {
	
	public InsufficientStock(String msg)
	{
		super(msg);
	}
	public InsufficientStock(String msg,Throwable cause)
	{
		super(msg,cause);
	}

}
