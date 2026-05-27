package com.kh.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public StudyBean Study() {
		return new StudyBean();
	}
	
	@Bean
	public StudyBoot studyBoot() {
		return new StudyBoot();
	}
	
}
