package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	@RequestMapping("/greetings")
	public String greeting(Model model)	{
		model.addAttribute("message", "Chris Waugh!");
		return "greeting";
	}

}
