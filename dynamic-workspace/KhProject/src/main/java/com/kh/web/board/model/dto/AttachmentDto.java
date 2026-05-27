package com.kh.web.board.model.dto;

import java.sql.Date;

public class AttachmentDto {
//	FILE_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
//	REF_BNO NUMBER NOT NULL,
//	ORIGIN_NAME VARCHAR2(100) NOT NULL,
//	CHANGE_NAME VARCHAR2(50) NOT NULL,
//	FILE_PATH VARCHAR2(100) NOT NULL,
//	BOARD_TYPE CHAR(1) NOT NULL,
//	FILE_LEVEL NUMBER NOT NULL,
//	CREATE_DATE DATE DEFAULT SYSDATE
	
	private Long fileNo;
	private Long refBno;
	private String originName;
	private String changeName;
	private String filePath;
	private char boardType;
	private int fileLevel;
	private Date creatDate;
	
	public AttachmentDto() {
		super();
	}
	public AttachmentDto(Long fileNo, Long refBno, String originName, String changeName, String filePath,
			char boardType, int fileLevel, Date creatDate) {
		super();
		this.fileNo = fileNo;
		this.refBno = refBno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.boardType = boardType;
		this.fileLevel = fileLevel;
		this.creatDate = creatDate;
	}
	
	public Long getFileNo() {
		return fileNo;
	}
	public Long getRefBno() {
		return refBno;
	}
	public String getOriginName() {
		return originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public char getBoardType() {
		return boardType;
	}
	public int getFileLevel() {
		return fileLevel;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	
	public void setFileNo(Long fileNo) {
		this.fileNo = fileNo;
	}
	public void setRefBno(Long refBno) {
		this.refBno = refBno;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setBoardType(char boardType) {
		this.boardType = boardType;
	}
	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	
	
}
