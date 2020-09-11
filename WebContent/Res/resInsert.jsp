<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resInsert.jsp</title>
</head>
<body>
<h3>식당등록</h3>
	<form method="post" name="frm" id="frm" 
		  action="${pageContext.request.contextPath}/resInsert.do">
		<div>
			<label>제목</label>
			<input type="text" name="title" id="title">
		</div>
		<div>
			<label>내용</label>
			<textarea name="content" id="content"></textarea>
		</div>
		<div>
			<label>식당이름</label>
			<input type="text" name="name" id="name">
		</div>
		<div>
			<label>전화번호</label>
			<input type="text" name="tel" id="tel">
		</div>
		<div>
			<label>주소</label>
			<input type="text" name="address" id="address">
		</div>
		<div>
			<button type="reset" name="reset">초기화</button>
			<button>등록</button>
		</div>
	</form>
</body>
</html>