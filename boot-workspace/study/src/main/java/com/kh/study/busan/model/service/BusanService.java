package com.kh.study.busan.model.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusanService {

	public String getRes(int page) {
		
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=b54b87418afb73be99c8b62aff4d30372cfb0bd284ae8291cf289ced2b0af86f&numOfRows=6&resultType=json";
		url += "&pageNo=" + page;
		
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		String apiResponse = new RestTemplate().getForObject(uri, String.class);
		return apiResponse;
	}

	public String getDetail(int seq) {
		
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=b54b87418afb73be99c8b62aff4d30372cfb0bd284ae8291cf289ced2b0af86f&pageNo=1&numOfRows=1&resultType=json";
		url += "&UC_SEQ=" + seq;
		
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		String apiResponse = new RestTemplate().getForObject(uri, String.class);
		return apiResponse;
	}

}
