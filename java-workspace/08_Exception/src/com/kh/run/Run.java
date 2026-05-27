package com.kh.run;

import com.kh.controller.CheckedException;
// import com.kh.controller.UncheckedException;

public class Run {

	public static void main(String[] args) {

	//	UncheckedException ue = new UncheckedException();
		CheckedException ce = new CheckedException();
	//	ue.divZero();
	//	ue.code();
	//	ue.multiCatch();
	//	ue.orderByCatch();
		ce.readString();
	
	}

}
