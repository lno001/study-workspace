package com.kh.chap03.model.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileCharDao {
	
	// 프로그램 --> 외부매체(파일)
	// 출력
	public void outputToFile() {
		// FileWriter : 파일로 데이터를 2Byte단위로 출력하는 스트림
		
		try(FileWriter fw = new FileWriter("c_char.txt")){
			fw.write("문자스트림은 이렇게도 나가요~~~\n");
			fw.write("입출력은 재미가 있다~~~\n");
			fw.write("李");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeDiary() {
		// 사용자에게 다이어리 내용을 입력받아서 외부파일로 출력
		// 내보낼 파일명 : 2026년 03월 30일 오늘의 다이어리.txt
		Date now = new Date();
		System.out.println(now);
		String title = new SimpleDateFormat("yyyy년 M월 dd일").format(now);
		System.out.println(title);
		StringBuilder sb = new StringBuilder();
		sb.append(title);
		sb.append(" 오늘의 다이어리.txt");
		
		try(FileWriter fw = new FileWriter(sb.toString());
			Scanner sc = new Scanner(System.in)){
			System.out.print("오늘의 다이어리를 작성해보세요 > ");
			String content = sc.nextLine();
			fw.write("오늘의 다이어리 내용 : \t" + content);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
