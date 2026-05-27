package com.kh.chap05.model.vo;

public class Member {
	// 웹사이트를 만들건데 회원의 정보를 어딘가에 저장해두어야한다.
	// [필드부]
	// 아이디, 비밀번호, 닉네임
	private String userId;
	private String userPwd;
	private String nickName;
	
	// [ 생성자부 ]
//	public Member(String userId, String userPwd, String nickName) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.nickName = nickName;
//	}
	// 기본생성자(매개변수가 존재하지 않는 생성자)
	public Member() {
		System.out.println("생성자 호출");
	}
	public Member(String userId) {
		System.out.println("유저아이디~");
		this.userId = userId;
	}
	public Member(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public Member(String userId, String userPwd, String nickName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.nickName = nickName;
	}
	

	// [ 메소드부 ]
	// getter() / setter() / info()
	
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getNickName() {
		return nickName;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String info() {
		return "[ 아이디 : " + userId + ", 비밀번호 : " + userPwd + ", 닉네임 : " + nickName + " ]";
	}
	
	
	
	
	
}
