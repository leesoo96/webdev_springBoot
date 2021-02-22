package com.koreait.mango.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Getter;
import lombok.Setter;

// Entity - 테이블과 1대 1 매칭
@Getter
@Setter
public class UserEntity implements UserDetails {

	private int userPk;
	private String provider;
	private String uid;
	private String upw;
	private String email;
	private String profileImg;
	private String nm;
	private String auth; // ROLE_USER
	private String regDt;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
	}
	
	@Override
	public String getPassword() {		
		return this.upw;
	}
	
	@Override
	public String getUsername() {	
		return this.uid;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {	
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
