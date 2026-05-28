package com.kh.study.board.model.dto;

import java.sql.Date;

public class BoardDto {
	private Long boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Long count;
	private Date createDate;
	public BoardDto() {
		super();
	}
	public BoardDto(Long boardNo, String boardTitle, String boardWriter, String boardContent, Long count,
			Date createDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
	}
	public Long getBoardNo() {
		return boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public Long getCount() {
		return count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardContent=" + boardContent + ", count=" + count + ", createDate=" + createDate + "]";
	}
	
}
