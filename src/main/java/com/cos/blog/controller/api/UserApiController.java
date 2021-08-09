package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user,
			@AuthenticationPrincipal PrincipalDetail principal){
		userService.회원수정(user,principal);
		
		
		
//		Authentication authenticaion =
//				new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
//		SecurityContext securityContext =SecurityContextHolder.getContext();
//		
//		
//		securityContext.setAuthentication(authenticaion);
//		
//		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
// 전통적인 방식의 로그인 방법
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		User principal = userService.로그인(user);
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//		
//	}
}
