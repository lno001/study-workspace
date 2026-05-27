package com.kh.chap02.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDao {

	// 파일에 프로그램에서 만들어진 테이터를 출력(ByteStream사용)
	// FileOutputStream
	public void outputToFile() {
		// 출력 : 프로그램 내의 데이터를 밖으로 내보내겠다. 프로그램 --> 외부(파일)
		// 1. FileOutputStream객체 생성
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("a_byte.txt");
			// 생성자 호출 시 파일명을 전달, 존재하지않는 파일명일 경우 해당 파일을 생성하면서 스트림 생성
			
			// 2. 스트림을 통해 데이터를 출력 : write() 호출
			fos.write(0);
			fos.write(97);
			fos.write(98);
			fos.write(99);
			
			byte[] arr = {101, 102, 103};
			fos.write(arr);
			
			fos.write('A');
			fos.write('B');
			fos.write('이');
			fos.write('일');
			fos.write('섭');
			
			// 한글은 2Byte이기 때문에 깨짐
			// 3. 스트림의 사용이 끝남
			// 반드시 해야하는 약속
			// 코드상에서 사용이 전부 종료되었다면 반드시 자원반납을 해주어야함
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		try {
			if(fos != null) {
				fos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inputFromFile() {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("a_byte.txt");
			
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
			
//			while(fis.read() != -1) {
//				System.out.println(fis.read());
//			}
			
//			while(true) {
//				int value = fis.read();
//				if(value != -1) {
//					System.out.println((char)value);
//				} else {
//					break;
//				}
//			}
			int value = 0;
			while((value = fis.read()) != -1) {
				System.out.println((char)value);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
