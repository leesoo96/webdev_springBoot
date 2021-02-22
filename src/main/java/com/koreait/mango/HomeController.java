package com.koreait.mango;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.mango.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	final HomeService service;

	@GetMapping({"/", "/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/denied")
	public void denied() {}
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join") // 회원가입
	public String join(UserEntity p) {
		service.join(p);
		
		return "redirect:/login";
	}
}
