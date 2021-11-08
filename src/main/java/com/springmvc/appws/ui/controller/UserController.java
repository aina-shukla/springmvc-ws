package com.springmvc.appws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springmvc.appws.models.request.UserDetailsRequest;
import com.springmvc.appws.models.response.UserDetailsResponse;
import com.springmvc.appws.service.UserService;
import com.springmvc.appws.shared.dto.UserDto;

@RestController
@RequestMapping("mvcapp")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "Get called..";
	}

	@PostMapping
	public UserDetailsResponse createUser(@RequestBody UserDetailsRequest uDetails) {
		UserDetailsResponse response = new UserDetailsResponse();
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(uDetails, dto);

		UserDto createdUser = userService.createUser(dto);
		BeanUtils.copyProperties(createdUser, response);

		return response;
	}

	@PutMapping
	public String updateUser() {
		return "Update called..";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete called..";
	}
}