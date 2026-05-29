package com.kh.study.festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.study.festival.model.service.FestivalService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/festivals")
public class FestivalController {
	
	@Autowired
	private FestivalService service;
	
	@GetMapping
	public String getList(@RequestParam(name="page", defaultValue = "1") int page) {
		return service.getList(page);
	}
	
	
	
}
