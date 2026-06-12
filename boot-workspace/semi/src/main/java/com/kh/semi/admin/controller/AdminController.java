package com.kh.semi.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public String findAllMembers() {
		return "회원 전체 정보";
	}
}
