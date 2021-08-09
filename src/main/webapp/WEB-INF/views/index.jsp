<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<c:forEach var="board" items = "${boards.content}">
	<div class="container">
		<div class="card m-3">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<a href="/board/${board.id }" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</div>
</c:forEach>
<ul class="pagination justify-content-center">
 <c:choose>
 	<c:when test="${boards.number lt 3 }">
 	 <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-3}">Previous</a></li>
 	</c:when>
 	<c:otherwise>
 	 <li class="page-item"><a class="page-link" href="?page=${boards.number-3}">Previous</a></li>
 	</c:otherwise>
 </c:choose>
 
 <c:choose>
 	<c:when test="${boards.first}">
 	 <li class="page-item"><a class="page-link" href="?page=${boards.number}">${boards.number }</a></li>
	 <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">${boards.number + 1 }</a></li>
	 <li class="page-item"><a class="page-link" href="?page=${boards.number+2}">${boards.number + 2 }</a></li>
 	</c:when>
 	<c:when test="${boards.last}">
 	<li class="page-item"><a class="page-link" href="?page=${boards.number - 1}">${boards.number - 2 }</a></li>
	 <li class="page-item"><a class="page-link" href="?page=${boards.number -2}">${boards.number -1 }</a></li>
	 <li class="page-item"><a class="page-link" href="?page=${boards.number}">${boards.number }</a></li>
 	</c:when>
 	<c:otherwise>
 	 <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">${boards.number -1}</a></li>
	 <li class="page-item"><a class="page-link" href="?page=${boards.number}">${boards.number }</a></li>
	 <li class="page-item"><a class="page-link" href="?page=${boards.number +1}">${boards.number + 1 }</a></li>
 	</c:otherwise>
 </c:choose>
 
   
  <c:choose>
 	<c:when test="${(boards.totalPages - boards.number) le 3}">
 	 <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+3}">Next</a></li>
 	</c:when>
 	<c:otherwise>
 	 <li class="page-item"><a class="page-link" href="?page=${boards.number+3}">Next</a></li>
 	</c:otherwise>
 </c:choose>
  
</ul>

<%@ include file="layout/footer.jsp"%>
