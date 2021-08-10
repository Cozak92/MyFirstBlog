package com.cos.blog.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.auth.PrincipalDetail;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repositoy.UserRepositoy;

@Service
public class UserService {

	@Autowired
	private UserRepositoy userRepositoy;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Transactional
	public User 회원찾기(String email) {
		return userRepositoy.findByEmail(email).get();
	}
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encpassword = encoder.encode(rawPassword);
		user.setRole(RoleType.USER);
		user.setPassword(encpassword);
		userRepositoy.save(user);	
	}
	
	@Transactional
	public void 회원수정(User user,PrincipalDetail principal) {
		User modifiedUser = userRepositoy.findById(user.getId()).
				orElseThrow(()->{
			return new IllegalArgumentException("회원 수정 실패 : 회원을 찾을수 없습니다.");
				}); 
		if(user.getId() != principal.getUser().getId()) {
			 throw new IllegalStateException("회원 수정 실패 : 해당 회원을 수정할 권한이 없습니다.");
		}
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		modifiedUser.setPassword(encPassword);
		modifiedUser.setEmail(user.getEmail());
		
		// 세션처리 회원정보 바뀐것을 바로 수정하기 위해서 사용
		Authentication authetication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(modifiedUser.getUsername(),rawPassword));
		SecurityContextHolder.getContext().setAuthentication(authetication);
	}
}
	
	
// 전통적인 방식 로그인
//	@Transactional(readOnly = true) //select 트랜잭션 시작, 서비스 종료 트랜잭션 종료 (정합성유지)
//	public User 로그인(User user) {
//		return userRepositoy.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//	}
