package com.cos.blog.controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cos.blog.model.KakaoProfile;
import com.cos.blog.model.OAuthToken;
import com.cos.blog.model.User;
import com.cos.blog.service.UserKakaoService;
import com.cos.blog.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//인증이 안된 사용자들이 출입 할 수 있는 경로를 /auth/**
// 그냥 주소가 /이면 index.jsp


@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	@Autowired
	private UserKakaoService userKakaoservice;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakakoCallback(String code) {
	
		KakaoProfile kakaoprofile = userKakaoservice.카카오인증(code);
		UUID garbagePassword = UUID.randomUUID();
		
		User kakoUser = User.builder()
				.username(kakaoprofile.getKakaoAccount().getEmail()+"_"+kakaoprofile.getId())
				.password(garbagePassword.toString())
				.email(kakaoprofile.getKakaoAccount().getEmail())
				.build();
		User originUser = userservice.회원찾기(kakaoprofile.getKakaoAccount().getEmail());
		
		if(originUser == null) {
			userservice.회원가입(kakoUser);
			Authentication authetication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakoUser.getUsername(),garbagePassword));
			SecurityContextHolder.getContext().setAuthentication(authetication);
			return "redirect:/";
		}
		else {
			// 이미 가입된 회원
			return "redirect:/";
		}

		
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		
		return "user/updateForm";
	}
	

}
