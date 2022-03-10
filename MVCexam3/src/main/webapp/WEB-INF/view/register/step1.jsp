<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"></spring:message></title>
</head>
<body>
	<h2><spring:message code="term"></spring:message></h2>
		<p>약관 내용</p>
		<form action="step2" method="post">
			<label>
				<input type="checkbox" name="agree" value="true">
				<spring:message code="term.agree"></spring:message>
			</label>
				<input type="submit" value="<spring:message code="next.btn"></spring:message>">
		</form>
</body>
</html>