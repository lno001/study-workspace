package com.kh.chap02.run;

import com.kh.chap02.model.dao.FileByteDao;

public class Run {

	public static void main(String[] args) {
		
		FileByteDao fbd = new FileByteDao();
	//	fbd.outputToFile();
		fbd.inputFromFile();
		

	}

}
