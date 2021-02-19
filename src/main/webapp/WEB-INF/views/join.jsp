<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	
	<div>
		<form action="/join" method="post">
			<div><input type="text" name="uid" placeholder="아이디를 입력해주세요"></div>
			<div><input type="password" name="upw" placeholder="비밀번호를 입력해주세요"></div>
			<div><input type="text" name="email" placeholder="이메일을 입력해주세요"></div>
			<div><input type="text" name="nm" placeholder="성함을 입력해주세요"></div>
			<button type="submit">회원가입</button>
			<input type="hidden" name="provider" value="mango">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		</form>
	</div>
	<div>
		<a href="/login">로그인</a>
	</div>
</body>
</html>