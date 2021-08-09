<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

		<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<br/>
		<br/>
		<div>
			글번호 : <span id = "id" >${board.id }</span>
			작성자 : <span id="username">${board.user.username }</span>
		</div>
		<br/>
			<h3 id = "boardTitle">${board.title}</h3>
		<hr/>
		  <div>
		  ${board.content}
		  </div>

		<hr/>
		<c:if test= "${board.user.id == principal.user.id}">
			<a href="/board/${board.id }/updateForm" id="btn- update" class="btn btn-warning">수정</a>
			<button id="btn-delete" class="btn btn-danger">삭제</button>
		</c:if>

		
</div>


<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
