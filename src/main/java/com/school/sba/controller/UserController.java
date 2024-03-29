package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.requestdto.UserRequest;
import com.school.sba.responsedto.UserResponse;
import com.school.sba.service.UserService;
import com.school.sba.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@PostMapping("users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(@RequestBody @Valid UserRequest userRequest) {
		System.out.println("dfghjkl");
		return userService.saveUser(userRequest);
	}
	
}
