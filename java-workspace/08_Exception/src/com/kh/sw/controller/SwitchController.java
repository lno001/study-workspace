package com.kh.sw.controller;

import com.kh.sw.model.vo.Switch;
import com.kh.sw.util.SwitchUtil;
import com.kh.sw.util.SwitchUtilImpl;

public class SwitchController {
	private Switch s = new Switch(false);
	
	public boolean toggleSwitch() {
		SwitchUtil su = new SwitchUtilImpl();
		boolean on = su.toggle(s);
		return on;
//		return new SwitchUtilImpl().toggle(s);
	}
}
