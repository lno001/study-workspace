package com.lim.spring.chara.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lim.spring.chara.model.service.CharaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("charaboards")
@RequiredArgsConstructor
public class CharaController {

	private final CharaService service;
	
	
	@GetMapping
	public ModelAndView findAll(ModelAndView mv,
								@RequestParam(name="page", defaultValue = "1") String page) {
		
		Map<String, Object> map = service.findAll(page);
		
		mv.addObject("map", map).setViewName("chara/boards");
		
		return mv;
	}
	
}
