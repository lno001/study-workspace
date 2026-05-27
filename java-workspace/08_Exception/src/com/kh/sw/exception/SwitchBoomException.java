package com.kh.sw.exception;

/**
 * 이 예외 클래스는 RuntimeException을 상속받아 구현하고 있으며,
 * 스위치를 눌렀을 때 10%확률로 폭발이 일어나니 때문에 예외를 발생시키려고 구현하였음
 * 
 * @author 종로 501강의실 이일섭
 * @since 2026-03-27
 */
public final class SwitchBoomException extends RuntimeException {
// Alt + Shift + J
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6587728789206058278L;

	public SwitchBoomException() {
		super();
	}
	
	public SwitchBoomException(String msg) {
		super(msg);
	}
	

}
