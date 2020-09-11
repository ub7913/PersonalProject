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
				<td>${res.no}</td>
				<td>${res.name}</td>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>