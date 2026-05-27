package com.kh.chap02.model.vo;


public class AosGame extends Game {
	private int characterCount;

	public AosGame() {
		super();
		System.out.println("나는 자식 클래스다.");
	}

	public AosGame(String gameName, String publisher, int characterCount) {
		super(gameName, publisher);
		this.characterCount = characterCount;
	}

	public int getCharacterCount() {
		return characterCount;
	}

	public void setCharacterCount(int characterCount) {
		this.characterCount = characterCount;
	}
	
	public String info() {
		return super.info() + ", 캐릭터 수 : " + characterCount;
	}
}
