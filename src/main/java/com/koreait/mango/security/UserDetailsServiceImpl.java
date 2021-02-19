package com.koreait.mango.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.koreait.mango.HomeMapper;
import com.koreait.mango.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
// DB로 객체를 보낸다(쿼리문실행)
	
	final HomeMapper mapper;
	
	@Override                                       // 아이디값이 넘어온다
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity p = new UserEntity();
		p.setUid(username);
		
		return mapper.selUser(p);
	}
}
