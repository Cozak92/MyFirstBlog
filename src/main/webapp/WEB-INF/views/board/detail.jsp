<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

		<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<br/>
		<br/>
		<div>
			글 번호 : <span id ="id" >${board.id }</span>
			작성자 : <span id="username">${board.user.username }</span>
		</div>
		<br/>
		<div class="form-group">
			<h3 id = "boardTitle">${board.title}</h3>
		</div>
		<hr/>
		<div class="form-group">

		  <div>
		  ${board.content}
		  </div>
		</div>
		<hr/>
		
		<button id="btn- update" class="btn btn-warning">수정</button>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
		
</div>





<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
