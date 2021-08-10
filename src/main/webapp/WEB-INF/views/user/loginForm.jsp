<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form action="/auth/loginProc" method = "POST">
		<div class="form-group">
			<label for="username">아이디</label> <input type=text  name = "username" class="form-control" placeholder="아이디를  입력하세요." id="username">
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password" name = "password"class="form-control" placeholder="비밀번호를 입력하세요." id="password">
		</div>
		
		<div class="form-group form-check">
			<label class="form-check-label"> 
			<input class="form-check-input" name = "remember-me"type="checkbox"> 로그인 상태 유지
			</label>
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
		<a href ="https://kauth.kakao.com/oauth/authorize?client_id=5c68629c00d48cb57e2fcaf7fca1875a&redirect_uri=http://localhost:4646/auth/kakao/callback&response_type=code"><img height="38px" src="/image/kakao_login_button.png"></a>
	</form>
	
	

</div>

<%@ include file="../layout/footer.jsp"%>