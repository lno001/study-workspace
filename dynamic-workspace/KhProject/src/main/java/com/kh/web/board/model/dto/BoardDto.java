package com.kh.web.board.model.dto;

import java.sql.Date;

public class BoardDto {
//	BOARD_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
//	USER_NO NUMBER REFERENCES WEB_MEMBER,
//	BOARD_TITLE NVARCHAR2(50) NOT NULL,
//	BOARD_CONTENT NVARCHAR2(2000) NOT NULL,
//	CREATE_DATE DATE DEFAULT SYSDATE,
//	MODIFY_DATE DATE DEFAULT SYSDATE,
//	COUNT NUMBER DEFAULT 0,
//	STATUS CHAR(1) DEFAULT 'N' CHECK(STATUS IN('Y', 'N'))
	
	private long boardNo;
	private long userNo;
	private String boardTitle;
	private String boardContent;
	private Date createDate;
	private Date modifyDate;
	private int count;
	private char status;
	private String userName;
	private String src;
	
	public BoardDto() {}

	public BoardDto(long userNo, String boardTitle, String boardContent) {
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public BoardDto(long boardNo, long userNo, String boardTitle, String boardContent, Date createDate, Date modifyDate,
			int count, char status) {
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.count = count;
		this.status = status;
	}
	
	public BoardDto(long boardNo, long userNo, String boardTitle, String boardContent, Date createDate, Date modifyDate,
			int count, char status, String userName) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.count = count;
		this.status = status;
		this.userName = userName;
	}
	
	public BoardDto(long boardNo, long userNo, String boardTitle, String boardContent, Date createDate, Date modifyDate,
			int count, char status, String userName, String src) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.count = count;
		this.status = status;
		this.userName = userName;
		this.src = src;
	}

	public long getBoardNo() {
		return boardNo;
	}

	public long getUserNo() {
		return userNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public int getCount() {
		return count;
	}

	public char getStatus() {
		return status;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getSrc() {
		return src;
	}

	public void setBoardNo(long boardNo) {
		this.boardNo = boardNo;
	}

	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", userNo=" + userNo + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", count=" + count
				+ ", status=" + status + ", userName=" + userName + ", src=" + src + "]";
	}
	
	
}
