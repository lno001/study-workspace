package com.kh.network.run;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Run {

	public static void main(String[] args) {
		
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println(localHost);
			System.out.println(localHost.getHostName());
			System.out.println(localHost.getHostAddress());
			
			System.out.println("=================================================================");
			
			// 도메인 네임을 이용해서 서버컴퓨터와 관련된 정보를 얻어 낼 수 있음
			
			InetAddress googleHost = InetAddress.getByName("www.google.com");
			
			System.out.println(googleHost);
			
			// 자바만 가지고 클라이언트와 서버의 간단한 통신하는 프로그램을 구현
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
