package com.kh.homework.lim.user.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class LimUser {
	/*
	USER_NO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	USER_ID VARCHAR2(20) UNIQUE NOT NULL,
	USER_PWD VARCHAR2(20) NOT NULL,
	USER_NAME NVARCHAR2(20) NOT NULL,
	ROLE VARCHAR2(20) NOT NULL,
	STATUS CHAR(1) DEFAULT 'Y' CHECK(STATUS IN('Y', 'N')) NOT NULL,
	REG_DATE DATE DEFAULT SYSDATE NOT NULL
	 */
	
	private Long userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String role;
	private String status;
	private Date regDate;
}
