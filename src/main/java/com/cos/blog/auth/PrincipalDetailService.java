package com.cos.blog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repositoy.UserRepositoy;


@Service
public class PrincipalDetailService implements UserDetailsService  {
	
	@Autowired
	private UserRepositoy userRepositoy;
	
	// 시큐리티가 로그인 요청을 가로칠때 아이디와 패스워드를 가로채는데
	// password 부분처리는 알아서하지만 아이디가 DB에 있는지만 확인해서 리턴
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepositoy.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : " + username);
				});
		
		// 리턴하기전에 패스워드 자동으로 비교
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저정보가 저장
	}
}
