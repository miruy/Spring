<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"></spring:message></title>
</head>
<body>
	<p>
	<!-- 커맨드객체로 지정된 RegisterRequest 클래스를 *첫 글자만 소문자로 바꾸면 커맨드 객체*를 참조하는 변수가 됨
			따라서, 스프링MVC가 커맨드 객체의 클래스 이름을 사용해 커맨드객체를 view로 전달-->
	<spring:message code="register.done" arguments="${formData.name }"></spring:message>
	</p>
	
	<p>
		<a href="<c:url value='/main'/>">[<spring:message code="go.main"></spring:message>]</a>
	</p>
</body>
</html>