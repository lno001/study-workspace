package com.kh.spring.ajax.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring.ajax.model.service.ApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Controller
@RestController
@RequestMapping(value = "api", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class ApiController {
	
	private final ApiService apiService;
	

	// @ResponseBody
	// @GetMapping(value = "api/blog", produces = "application/json; charset=UTF-8")
	@GetMapping("/blog")
	public String searchBlog(@RequestParam(value = "query") String query) {
		
		String res = apiService.request(query);
		
		
		return res;
	}
	
	// @ResponseBody
	// @GetMapping(value = "api/foods", produces = "application/json; charset=UTF-8")
	@GetMapping("/foods")
	public String searchFoods(@RequestParam(value="line") String line, @RequestParam(value="page") String page) {
		String res = apiService.searchFoods(line, page);
		return res;
	}
	
	@GetMapping("/service")
	public String searchServiceArea(@RequestParam(value="service") String service) {
		
		return apiService.searchServiceArea(service);
	}
	
}
