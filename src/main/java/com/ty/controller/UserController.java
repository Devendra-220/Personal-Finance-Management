package com.ty.controller;

import java.security.Provider.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.dto.UserDTO;
import com.ty.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> register( @RequestBody UserDTO dto) {
		UserDTO savedUser = service.register(dto);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
}
