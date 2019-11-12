package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("inside HomeController");
		return "Das boot,reporting for the duty";
	}
	

}
