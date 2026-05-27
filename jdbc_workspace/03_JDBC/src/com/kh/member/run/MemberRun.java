package com.kh.member.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.member.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		prop.setProperty("A", "B");
		
		try {
			prop.storeToXML(new FileOutputStream("member-mapper.xml"), "MEMBER SQL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		MemberView mv = new MemberView();
		
		mv.mainMenu();
	}

}
