package com.admin.AdminControlMongoReact.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.AdminControlMongoReact.Model.User;
import com.admin.AdminControlMongoReact.UserRepository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public List<User> GetUsers(){
		System.out.println("User details have been accessed");
		return userRepository.findAll();	
	}
	
	@GetMapping("/test")
	public String test(){
		return "Server is up and running";
	}
	
	
	
	@GetMapping("/{id}")
	public User GetUsers(@PathVariable String id){
		return userRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/")
	public User SaveUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/")
	public User EditUser(@RequestBody User newUser) {
		User oldUser = userRepository.findById(newUser.getId()).orElse(null);
		oldUser.setUserName(newUser.getUserName());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setPassword(newUser.getPassword());
		return oldUser;	
		}
	
	@DeleteMapping("/{id}")
	public String DeleteUser(@PathVariable String id) {
		userRepository.deleteById(id);
		return id;
	}
}
