package com.naresh.Database.Entity;
 import com.naresh.Database.Entity.Order;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Users9")
public class User {
	
	
	@Id
	private String  userId;
	
	
	private String  userName;
	
	private String  email;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Order> order;
	
	 
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public User(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	 

	 
 

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

 

	public User(String userId, String userName, String email, List<Order> order) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + "]";
	}

	public User() {
		super();
	}
	
	
	

}
 