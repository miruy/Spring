<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"></spring:message></title>
</head>
<body>
	<h2><spring:message code="member.info"></spring:message></h2>
	<form:form action="step3" commandName="formData">
		<p>
			<label><spring:message code="email"></spring:message><br>	
			<form:input path="email"></form:input>
			<form:errors path="email"></form:errors>
			</label>
		</p>
		
		<p>
			<label><spring:message code="name"></spring:message><br>
				<form:input path="name"></form:input>
				<form:errors path="name"></form:errors>
			</label>
		</p>
		
		<p>
			<label><spring:message code="password"></spring:message><br>
				<form:password path="password"></form:password>
				<form:errors path="password"></form:errors>
			</label>
		</p>
		
		<p>
			<label><spring:message code="password.confirm"></spring:message><br>
				<form:password path="confirmPassword"></form:password>
				<form:errors path="confirmPassword"></form:errors>
			</label>
		</p>
		
		<input type="submit" value="<spring:message code="register.btn"></spring:message>">
	</form:form>
</body>
</html>