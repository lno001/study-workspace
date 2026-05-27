package com.kh.sw.util;

import com.kh.sw.exception.SwitchBoomException;
import com.kh.sw.model.vo.Switch;

public class SwitchUtilImpl implements SwitchUtil {

	@Override
	public boolean toggle(Switch s) {
		boom();
		s.setOn(!s.isOn());
		return s.isOn();
		
//		boolean newState = !s.isOn();  // 현재 상태 반전
//	    s.setOn(newState);             // 스위치 상태 업데이트
//	    return newState;               // 토글 후 상태 반환
		
	}
	
	/**
	 * 이 메소드는 스위치를 눌렀을 때 폭⭐발
	 */
	private void boom() {
		// 90% 확률로 아무문제 없음
		// 10% 확률로 대폭발
		
		int rand = (int)(Math.random() * 100) +1;
		
		if (rand <= 10) {
			throw new SwitchBoomException("스위치 과부하가 와서 대폭발을 일으켰습니다.");
		}
		
	}
}
