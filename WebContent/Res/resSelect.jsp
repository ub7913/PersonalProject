<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<div>
		<label>식당이름</label><br>
		${res.name}
	</div>
	<div>
		<p>${res.content}</p>
	</div>
	<a href="${pageContext.request.contextPath}/review/reviewInsert.jsp">
		<button>리뷰작성</button>
	</a>
	<c:forEach items="${list}" var="rev">
		<div>작성자 : ${rev.poster}</div>
		<div>리뷰내용 : ${rev.content}</div>
		<div>작성일자 : ${rev.regdate}</div>
	</c:forEach>
	
</body>
</html>