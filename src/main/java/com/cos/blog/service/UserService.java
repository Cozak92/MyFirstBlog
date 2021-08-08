package com.cos.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repositoy.UserRepositoy;

@Service
public class UserService {

	@Autowired
	private UserRepositoy userRepositoy;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encpassword = encoder.encode(rawPassword);
		user.setRole(RoleType.USER);
		user.setPassword(encpassword);
		userRepositoy.save(user);	
	}
}
	
	
// 전통적인 방식 로그인
//	@Transactional(readOnly = true) //select 트랜잭션 시작, 서비스 종료 트랜잭션 종료 (정합성유지)
//	public User 로그인(User user) {
//		return userRepositoy.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//	}
