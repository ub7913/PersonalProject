<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resInsertOutput.jsp</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/resList.do">
	<p>
	${param.title}이란 제목으로 식당 ${cnt}건이 등록 되었습니다.<br>
	식당 목록을 보시겠습니까?
	</p>
	<button>전체식당보기</button>
</form>
</body>
</html>