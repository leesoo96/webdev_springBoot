package com.koreait.mango;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.koreait.mango.model.UserEntity;
import com.koreait.mango.security.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService {

	final UserDetailsServiceImpl service;
	final PasswordEncoder encoder;
	
//	회원가입
	public int join(UserEntity p) {
		p.setProvider("mango");
		
//		비밀번호 암호화
		String encodePw = encoder.encode(p.getPassword());
		p.setUpw(encodePw);
		
		return service.join(p);
	}
}
