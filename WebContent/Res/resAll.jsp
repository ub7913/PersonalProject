<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resAll.jsp</title>
</head>
<body>
<form method="post" name="frm" id="frm"
	  action="${pageContext.request.contextPath}/resSelect.do">
	<table border="1" id="members">
		<thead>
			<tr>
				<th>번호</th>
				<th>식당이름</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="res">
			<tr>
				<td><a href="#">${res.no}. ${res.name}</a></td>
				<td>${res.content}</td>
		</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>