package com.cos.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.auth.PrincipalDetail;

@Controller
public class BoardController {

	
//	@AuthenticationPrincipal PrincipalDetail principal <- 세션 찾는법
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		@GetMapping("/board/wirteForm")
		public String writeForm() {
			return "board/writeForm";
		}
}
