package com.kh.spring.ajax.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiService {
	
	// NAVER API서버로 요청을 보내서 응답을 변환해주는 메소드
	
	public String request(String query) {
		URI uri = null;
		try {
			uri = new URI("https://openapi.naver.com/v1/search/shop?query=" + URLEncoder.encode(query, "UTF-8"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", "qYmT9HJ8pCDOZbhB9x8H");
		headers.set("X-Naver-Client-Secret", "PgkHRSxhb0");
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		
		String res = response.getBody();
		// System.out.println(res);
		return res;
	}
	
	
    public void requestBlog(String query) {
        String clientId = "qYmT9HJ8pCDOZbhB9x8H"; //애플리케이션 클라이언트 아이디
        String clientSecret = "PgkHRSxhb0"; //애플리케이션 클라이언트 시크릿


        String text = null;
        try {
            text = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/shop.json?query=" + text;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);


        System.out.println(responseBody);
    }


    private String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


	private HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }


	public String searchFoods(String line, String page) {
		
		// 한국 도로공사 API서버로 요청을 보내고 응답을 받아서 다시 컨트롤러로 반환
		
		// https://data.ex.co.kr/openapi/restinfo/restBestfoodList?key=6449199726&type=json&numOfRows=100&pageNo=1
		
		StringBuilder sb = new StringBuilder();
		sb.append("https://data.ex.co.kr/openapi/restinfo/restBestfoodList?key=6449199726&type=json&numOfRows=10");
		sb.append("&pageNo=" + page);
		try {
			sb.append("&routeNm=" + URLEncoder.encode(line, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try {
			URI uri = new URI(sb.toString());
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(uri, String.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "";
	}


	public String searchServiceArea(String service) {
		// 한국 도로공사 API서버로 요청을 보내고 응답을 받아서 다시 컨트롤러로 반환
		
				// https://data.ex.co.kr/openapi/restinfo/restBestfoodList?key=6449199726&type=json&numOfRows=100&pageNo=1
				
				StringBuilder sb = new StringBuilder();
				sb.append("https://data.ex.co.kr/openapi/restinfo/restBestfoodList?key=6449199726&type=json&numOfRows=100");
				sb.append("&pageNo=1");
				try {
					sb.append("&stdRestNm=" + URLEncoder.encode(service, "UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				
				try {
					URI uri = new URI(sb.toString());
					RestTemplate restTemplate = new RestTemplate();
					return restTemplate.getForObject(uri, String.class);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				return "";
	}
	
}
