<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<c:forEach var="board" items = "${boards }">
	<div class="container">
		<div class="card m-3">
			<div class="card-body">
				<h4 class="card-title">제목 적는 부분</h4>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</div>
</c:forEach>


<%@ include file="layout/footer.jsp"%>
