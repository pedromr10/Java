package com.pedro.hello_world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.hello_world.domain.User;
import com.pedro.hello_world.services.HelloWorldService;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	
	@Autowired
	private HelloWorldService hwService;
	
	@GetMapping
	public String helloWorld() {
		return hwService.helloWorld("Pedro");
	}
	
	@PostMapping()
	public String helloWorldPost(@RequestBody User body) {
		return "Hello World, " + body.getName() + " - " + body.getEmail();
	}
	
}
