package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hi {
	
	@GetMapping("/")
	public String hi()	{
		return "hi";
	}

}
