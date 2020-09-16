<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewInsert.jsp</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/reviewInsert.do">
	<div>
		작성자 : <input type="text">
	</div>
	<div>
		리뷰 : <textarea></textarea>
	</div>
	<button>등록</button>
</form>	
</body>
</html>