package com.inmemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmemory.entity.UserData;
import com.inmemory.repo.UserRepo;

@SpringBootApplication
@RestController
@RequestMapping("/products")
public class InMemoryAuthenticationApplication {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(InMemoryAuthenticationApplication.class, args);
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getAll() {
		return "Get all from eKart";
	}

	@GetMapping("/get")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String getOneProduct() {
		return "Product from eKart";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to eKart";
	}

	@PostMapping("/add")
	public UserData addNewUser(@RequestBody UserData user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return user;

	}

}
