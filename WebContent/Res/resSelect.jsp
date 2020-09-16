<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resSelect.jsp</title>
<script>
	function reviewInsert() {
		location.href="reviewInsert.do"
	}
</script>
<style>
	.pagination li {
		display : inline-block;
		border : 15px solid white;
	}
	
	.pagination .active {
		border : 10px solid white;
		background-color : white;
		font-style : normal;
		font-weight : bold;
	
	}
</style>
</head>
<body>
<form name="searchFrm">
 	<input type="hidden" name="p" value="1">
</form>
	<div>
		<label>식당이름</label><br>
		${res.name}
	</div>
	<div>
		<p>${res.content}</p>
		<br>
		<br>
	</div>
	<a href="${pageContext.request.contextPath}/review/reviewInsert.jsp">
		<button>리뷰작성</button>
	</a>
	<c:forEach items="${list}" var="rev">
		<div>작성자 : ${rev.poster}</div>
		<div>리뷰내용 : ${rev.content}</div>
		<div>작성일자 : ${rev.regdate}</div>
		<hr>
	</c:forEach>
	<my:paging paging="${paging}" jsfunc="gopage"/>
	
<script>
	function gopage(p) {
		searchFrm.p.value = p;
		searchFrm.submit();
		//location.href="deptSelectAll?p=" + p;

	}
</script>
</body>
</html>