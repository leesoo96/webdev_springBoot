package com.koreait.mango;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.mango.model.UserEntity;

@Mapper
public interface HomeMapper {

//	회원가입
	int insUser(UserEntity p);
	
//	로그인
	UserEntity selUser(UserEntity p); 
}
