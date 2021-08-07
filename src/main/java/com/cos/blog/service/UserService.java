package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repositoy.UserRepositoy;

@Service
public class UserService {

	@Autowired
	private UserRepositoy userRepositoy;
	
	@Transactional
	public int 회원가입(User user) {
		try {
			userRepositoy.save(user);
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService 회원가입() :" + e.getMessage());
		}
		
		return -1;
		
	}
}
