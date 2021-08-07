package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 사용자가 요청 -> 응답(Html 파일) -> @Controller


@RestController // 사용자가 요청 -> 응답( Data)
public class httpControllerTest {
	
	@GetMapping("/http/get") // 컨트롤 + 스페이스 자동 생성
	public String getTest( Member m) {
		return "Get 요청" + m.getId() + m.getUsername() + m. getPassword() + m.getEmail();
	}
	@PostMapping("/http/post")
	public String postTest() {
		return "Post 요청";
	}
	@PutMapping("/http/put")
	public String putTest() {
		return "Put 요청";
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
