package com.cos.blog.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable){
		return boardRepositoy.findAll(pageable);
	}
	
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepositoy.findById(id)
				.orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기 실패 : 글을 찾을수 없습니다.");
		});
		
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardRepositoy.deleteById(id);		
	}

}

