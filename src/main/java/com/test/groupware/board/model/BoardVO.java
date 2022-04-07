package com.reffics.groupware.board.model;

import lombok.Data;

@Data
public class BoardVO {
	private String emplyId; //사원ID
	private String emplyNo; //사원번호
	private String emplyNm; //사원명
	private String phone;	//전화번호
	private String pwd;		//비밀번호
	private String createId;//생성ID
	private String createDt;//생성일시
	private String modId;	//수정ID
	private String modDt;	//수정일시
	
	private String type; // 검색타입
	private String content;//검색내용

}

