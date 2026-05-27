package com.kh.chap04.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {

	public static void main(String[] args) {
		
		Properties prop = new Properties(); // 상속의 잘못된 예
		System.out.println(prop);
		
		// prop.put("sdadas", new Sandwich("맛있음", "에그마요"));
		prop.setProperty("List", "LinkedList");
		
		try {
			prop.store(new FileOutputStream("test.properties"), "뭣?");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
