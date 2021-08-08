package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.auth.PrincipalDetail;
import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	private BoardService boardService;
//	@AuthenticationPrincipal PrincipalDetail principal <- 세션 찾는법
		@GetMapping("/")
		public String index(Model model) {
			model.addAttribute("boards", boardService.글목록());
			return "index";
		}
		
		@GetMapping("/board/wirteForm")
		public String writeForm() {
			return "board/writeForm";
		}
}
