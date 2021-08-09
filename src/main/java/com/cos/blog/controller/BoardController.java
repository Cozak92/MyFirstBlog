package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.auth.PrincipalDetail;
import com.cos.blog.repositoy.BoardRepository;
import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	
	
	
		@Autowired
		private BoardService boardService;
//	@AuthenticationPrincipal PrincipalDetail principal <- 세션 찾는법
		@GetMapping("/")
		public String index(Model model, @PageableDefault(size = 3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
			model.addAttribute("boards", boardService.글목록(pageable));
			return "index";
		}
		
		@GetMapping("/board/{id}")
		public String findById(Model model, @PathVariable int id) {
			model.addAttribute("board",boardService.글상세보기(id));
			return "board/detail";
		}
		
		@GetMapping("/board/wirteForm")
		public String writeForm() {
			return "board/writeForm";
		}
		
		@GetMapping("/board/{id}/updateForm")
		public String updateForm(@PathVariable int id, Model model) {
			model.addAttribute("board",boardService.글상세보기(id));
			return "board/updateForm";
		}
}
