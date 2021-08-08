package com.cos.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repositoy.BoardRepository;
import com.cos.blog.repositoy.UserRepositoy;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepositoy;

	
	@Transactional
	public void 글등록(Board board,User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepositoy.save(board);
	}
}

