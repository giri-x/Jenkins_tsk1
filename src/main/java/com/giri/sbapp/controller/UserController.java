package com.giri.sbapp.controller;
 
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.giri.sbapp.model.User;
import com.giri.sbapp.serviceimpl.UserServiceImpl;

 
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
 
	@Autowired
	UserServiceImpl service;
 
	@PostMapping
	public String insertUser(@RequestBody User user) {
		String msg = "";
		try {
			System.out.println(user);
			service.addUser(user);
			msg = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Failure";
		}
		return msg;
	}
 
	@GetMapping("/getEmail/{email}")
	public User viewUserByEmail(@PathVariable("email") String email) {
		System.out.print(email);
		return service.getUserByEmail(email);
	}
 
	@GetMapping("/all")
	public List<User> getUsers() {
		return service.getAllUsers();
	}
}