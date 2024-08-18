package com.naresh.Database.ThreadPractising;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadsDemo {
	
	@Async
	  public CompletableFuture<String> asyncMethod1()
	  {
		 System.out.println("iam asynchronmus method 1 ");
		 
		return CompletableFuture.completedFuture("result of asyncMethod1");  	  
	  }
	  public String  normalMehtod1()
	  {
		 System.out.println("iam normalMehtod1 "); 
		 
		 return "result of normalMehtod1";
	  }
	  public String  normalMehtod2()
	  {
		 System.out.println("iam normalMehtod2 "); 
		 
		 return "result of normalMehtod2";
	  }
}


