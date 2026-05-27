package com.kh.network.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProgram {

	public static void main(String[] args) {
		
		// 서버측 프로그램
		Scanner sc = new Scanner(System.in);
		
		// 자원 반납을 위해 미리 참조변수를 선언하고 null값으로 초기화
		
		ServerSocket server = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		// 1) 포트번호 지정
		
		int portNumber = 1234;
		
		try {
			// 2) ServerSocket객체 생성 및 포트결합(bind)
			server = new ServerSocket(portNumber);
			
			// 3) 대기상태
			System.out.println("클라이언트의 요청을 기다리는 중...");
			
			// 4) 연결 요청이 오면 수락 후 해당 클라이언트와 통신할 수 있는 서버 측 Socket객체 생성
			Socket socket = server.accept();
			System.out.println("클라이언트와 연결 성공!");
			
			// 5) 클라이언트와 통신할 수 있는 입/출력용 스트림 생성
			// 6) 보조스트림을 추가해서 성능 개선
			// 입력용 스트림 + 보조스트림
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// socket 객체가 제공해주는 입력용 기반스트림 => InputStream => 1Byte
			// 바이트스트림과 문자스트림을 호환해줄 수 있는 보조스트림 => InputStreamReader
			// 속도향상, 한글전달을 위한 입력용 보조스트림 => BufferedReader => 2Byte
			
			// 출력용 스트림
			pw = new PrintWriter(socket.getOutputStream());
			// PrintWriter는 2Byte짜리 문자용이지만 1Byte짜리에서도 호환이 가능
			
			// 7) 데이터 주고 받기
			while(true) {
				// 7_1) 입력받기
				String message = br.readLine();
				if(message == "null") {
					break;
				}
				System.out.println("클라이언트로부터 받은 메세지 : " + message);
				
				// 7_2) 출력하기
				System.out.print("클라이언트로부터 전송할 메세지 > ");
				String sendMessage = sc.nextLine();
				pw.println(sendMessage);
				
				// 스트림에 있는 데이터를 강제로 내보내기 위해서
				pw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(server != null) {
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			sc.close();
		}
	}
}
