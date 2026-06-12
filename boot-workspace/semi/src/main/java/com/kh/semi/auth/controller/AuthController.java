package com.kh.semi.auth.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.semi.api.model.vo.ApiResponse;
import com.kh.semi.auth.model.dto.LoginRequestDto;
import com.kh.semi.auth.model.dto.LoginResponse;
import com.kh.semi.auth.model.service.AuthService;
import com.kh.semi.token.model.service.TokenService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	private final TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto lrd) {
		LoginResponse res = authService.login(lrd);
		return ResponseEntity.ok(res);
	}

	@PostMapping("/refresh")
	public ResponseEntity<ApiResponse<Map<String, String>>> refresh(@RequestBody Map<String, String> refreshToken) {
		return ResponseEntity.status(201)
				.body(ApiResponse.created(tokenService.tokenRotation(refreshToken.get("refreshToken"))));
	}

	@GetMapping("/logout")
	public ResponseEntity<ApiResponse<Map<String, String>>> logout(@RequestParam("id") String memberId) {
		tokenService.logout(memberId);
		return ResponseEntity.status(200).body(ApiResponse.success("로그아웃 성공~", null));
	}
}
