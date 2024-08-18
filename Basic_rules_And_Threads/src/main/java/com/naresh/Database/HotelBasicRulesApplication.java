package com.naresh.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.naresh.Database.ThreadPractising.ThreadsDemo;

@SpringBootApplication
public class HotelBasicRulesApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ConfigurableApplicationContext context=SpringApplication.run(HotelBasicRulesApplication.class, args);
		
	 	ThreadsDemo threadsDemo=context.getBean(ThreadsDemo.class);
		
		   System.out.println("starting of main");
	
	 
 //  UseCase1:
		   /*     Thread t1=new Thread(()->
	       {   
	    	   for(int i=0;i<10;i++)
	    	   {
	    		   System.out.println("iam from t1("+i+")");
	    	   }
	       });
	       
	       Thread t2=new Thread(()->
	       {   
	    	   for(int i=0;i<2;i++)
	    	   {
	    		   System.out.println("iam from t2("+i+")");
	    	   }
	       });
	       
          t1.start();
          
          System.out.println("midle of main");

          
          t2.start();
		   
		     t2.join();
		     
		     t1.join();
	  
		   System.out.println("ending of main");   */

		   
 //  UseCase2:
	//  ***Aysnchronomus method calling ***  	
		   
		   
	/*	   CompletableFuture<String> future1=threadsDemo.asyncMethod1(); 
		   
		   
		   threadsDemo.normalMehtod(); 
		   
		   future1.join();
		   
		   
		   System.out.println("ending of main");   */
		   
//  UseCase3:
		   
	//  ***running normal as Aysnchronomus  method using runAync() ***  	
		   		   
		   
		 //  CompletableFuture future = CompletableFuture.runAsync(()->threadsDemo.normalMehtod());
		   
			
/*		   CompletableFuture<String> future = CompletableFuture.supplyAsync(()->threadsDemo.normalMehtod1());

		 
		   future.thenAccept(result->System.out.println(result));
		   
			  
			    System.out.println("hi");
			    
			    System.out.println("hello");
			    
			    
		    System.out.println("ending of main");    */
	
//  UseCase4:	    
	 
	// *********
 //  Running mutiple normal methods as asynchromous
		   
		   
	/*	CompletableFuture<String> future1=CompletableFuture.supplyAsync(()->threadsDemo.normalMehtod1());  
		   
		CompletableFuture<String> future2=CompletableFuture.supplyAsync(()->threadsDemo.normalMehtod2());  

		  	List<CompletableFuture<String>> result=new ArrayList<>();
		  	result.add(future1);
		  	result.add(future2);
		  	result.stream().forEach(future->future.thenAccept(res->System.out.println(res)));	
		  	
		  	  
		  	
		  	/*CompletableFuture  res =CompletableFuture.allOf(future1,future2);
		  	res.join(); */
 		  
		   /*	  System.out.println("hi");   
		   
	    System.out.println("ending of main");   */
 
		   
//  UseCase5:		  
	    
	    // main thread <- t1 thread <- normal mehtod(forkjoin thtread pool)
		   
		   Thread t1 =  new Thread(()->
	         {
	            for(int i=1;i<3;i++)
	           {
	           	 System.out.println("inside t1("+i+")");
	          	 
	           	CompletableFuture<String> future= CompletableFuture.supplyAsync(()->threadsDemo.normalMehtod1()); // it is running on separte thread(forkjoin thread pool not t1)
	           	
	           	String res=future.join();
	           	
	           	System.out.println(res);
	           	
	           }
	         
	         });	   
		   
		   t1.start();
		   
		   t1.join();
		   
		   
		    System.out.println("ending of main"); 
   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
	
		/*Demo d=new Demo();
		
		DemoSub ds=new DemoSub();
		
		
		d.myName();
		
		ds.myName();
	
		 String name="Lucky";
		
		 /*for(int i=0;i<name.length();i++)
		{
			System.out.println(name.charAt(i));
		}
		
		//  charArray char[] ch=['l','u','c','k','y'];
		
		char[] names=name.toCharArray();
		
		for(char ch:names)
		{
			System.out.println(ch);
		} */
		
		//  chars()
		
	// 	IntStream namess=name.chars(); wriitng at only one place using will throws stream closed
		
		// in list  we can store only non primitives . 
		
	/*	List<Character>  hh= name.chars().mapToObj(ch->(char)ch).map(ch->Character.toLowerCase(ch)).collect(Collectors.toList());
		
		 List<Character>  hhh= name.chars().mapToObj(ch->(char)ch).filter(ch->ch.equals('k')).collect(Collectors.toList());
		
		 
		
			System.out.println(name);
			

		for(Character H:hh)
		{
			System.out.println(H);
		}
		for(Character H:hhh)
		{
			System.out.println(H);
		}
		
	} */

}}
