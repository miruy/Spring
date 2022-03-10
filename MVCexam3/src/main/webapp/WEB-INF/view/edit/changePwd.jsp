<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="change.pwd.title"></spring:message></title>
</head>
<body>
	<p>
		<spring:message code="change.pwd.done"></spring:message>
	</p>
	
	<p>
		<a href="<c:url value='/main'/>">
			[<spring:message code="go.main"></spring:message>]
		</a>
	</p>
</body>
</html>