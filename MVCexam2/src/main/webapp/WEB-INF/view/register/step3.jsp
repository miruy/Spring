<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<p>
	<!-- 커맨드객체로 지정된 RegisterRequest 클래스를 *첫 글자만 소문자로 바꾸면 커맨드 객체*를 참조하는 변수가 됨
			따라서, 스프링MVC가 커맨드 객체의 클래스 이름을 사용해 커맨드객체를 view로 전달-->
	<strong>${formData.name }</strong>님의 회원 가입을 축하합니다.
	</p>
	
	<p>
		<a href="<c:url value='/main'/>">[홈 화면 이동]</a>
	</p>
</body>
</html>