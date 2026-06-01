package com.kh.homework.lim.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.homework.lim.user.model.dto.LimUserDto;
import com.kh.homework.lim.user.model.service.LimUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/lim/users")
@RequiredArgsConstructor
public class LimUserController {
	
	private final LimUserService limUserService;
	
	@PostMapping
	public ResponseEntity<Void> signUp(@RequestBody LimUserDto limUser){
		limUserService.signUp(limUser);
		return ResponseEntity.status(201).build();
	}
}
