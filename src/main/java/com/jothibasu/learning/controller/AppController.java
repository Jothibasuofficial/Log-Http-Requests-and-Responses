package com.jothibasu.learning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@RequestMapping("/")
	public String home() {
	return "Spring boot is working!";
	}
}
