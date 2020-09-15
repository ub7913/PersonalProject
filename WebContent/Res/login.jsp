<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login.jsp</title>
</head>
<body>
	<form method="post" name="frm" id="frm" 
		  action="login">
		<div>
			<label>ID </label>
			<input type="text" name="id">
		</div>
		<div>
			<label>PW </label>
			<input type="password" name="pw">
		</div>
		<button>로그인</button>
	</form>
</body>
</html>