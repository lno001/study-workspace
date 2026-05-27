package com.kh.chap01.run;

import java.io.File;
import java.io.IOException;

public class FileRun {

	public static void main(String[] args) {
		
		File file1 = new File("abc.txt");
		
		try {
			file1.createNewFile();
			
			// 폴더만들기
			File folder = new File("folder");
			
			folder.mkdir();
			
			File file2 = new File("folder/test.txt");
			file2.createNewFile();
			System.out.println(file2.isFile());				// 파일인지?
			System.out.println(file2.getName());			// 파일명이 무엇인지?
			System.out.println(file2.getAbsolutePath());	// 파일의 절대 경로가 어디인지?
			System.out.println(file2.length());				// 파일의 크기는 얼마인지?
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
	}

}
