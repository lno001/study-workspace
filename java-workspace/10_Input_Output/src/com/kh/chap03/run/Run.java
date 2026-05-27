package com.kh.chap03.run;

import com.kh.chap03.model.dao.FileCharDao;

public class Run {

	public static void main(String[] args) {
		
		FileCharDao fcd = new FileCharDao();
		
	//	fcd.outputToFile();
		fcd.writeDiary();
		
		
	}

}
