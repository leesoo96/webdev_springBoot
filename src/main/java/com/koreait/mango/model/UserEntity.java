package com.koreait.mango.model;

import lombok.Getter;
import lombok.Setter;

// Entity - 테이블과 1대 1 매칭
@Getter
@Setter
public class UserEntity {

	private int userPk;
	private String provider;
	private String uid;
	private String upw;
	private String email;
	private String profileImg;
	private String nm;
	private String regDt;
}
