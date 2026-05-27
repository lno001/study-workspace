package com.kh.football.model.dto;

public class BoardDto {
	private int boardNo;			// 각 게시글을 식별할 용도의 필드
	private String boardTitle;		// 게시글 제목을 저장할 필드
	private String boardContent;	// 게시글 내용을 저장할 필드
	private String boardWriter;		// 게시글 작성자를 저장할 필드
	private String password;		// 게시글 작성 시 비밀번호를 저장할 필드
	private String createDate;		// 게시글 작성 날짜를 저장할 필드
	
	public BoardDto(String boardTitle, String boardContent, String boardWriter, String password) {
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.password = password;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
