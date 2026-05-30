package com.kh.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("study")
public class StudyController {

//	@Autowired
//	private StudyBean StudyBean;
	
	@GetMapping
	public String test() {
		return "들어갑니다~";
	}
	
}
