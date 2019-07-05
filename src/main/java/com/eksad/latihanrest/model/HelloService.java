package com.eksad.latihanrest.model;

//import org.springframework.beans.factory.annotation.Autowired;

//import com.eksad.supermarket.dao.BrandDao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloService 
{
	
	private String greetings;
	
	public String sayHello(String name) {
		
		return "Hello, " + name;
	}
}
