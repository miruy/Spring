<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 내용</title>
</head>
<body>
	<p>응답 내용</p>
	<ul>
	<!-- 컬렉션 사용 방법 : 
		1. ansData객체가 응답 내용이 list형태로 담겨 저장되어있는 responses객체(AnsweredData클래스)를 이용해 응답 내용을 꺼내오고 있음
		2. ansData객체가 응답자의 정보가 저장되어있는 res객체(Respondent클래스)를 이용해 응답자 정보를 꺼내오고 있음  -->
	<!-- 중첩의 사용 : 
		  AsnweredDate클래스(응답자 정보클래스)와 Respondent클래스(답변, 응답자 정보클래스) 두 개를 ansData(surveyController)가 참조하고 있으므로, 
		  ansData(surveyController)가 두 클래스를 중첩 사용하고 있음  -->
	
	<c:forEach var="responses" items="${ansData.responses }" varStatus="status">
					<li>${status.index + 1}번 문항 : ${responses }</li>	
		</c:forEach>			
	</ul>
	
		  
	<!-- 위의 forEach문에서 responses객체를 ansData의 직접적인 객체이므로 참조연산자를 1번 사용
		 밑으 res객체는 AnsweredData클래스에 참조 선언된 Respondent클래스의 객체를 사용하고 있으므로(직접적인 객체 X) 참조연산자 2번 사용
		 -> 중첩 커맨드 객체 사용의 경우 값도 지정할 수 있음 -->	  
	<p>응답자 위치 : ${ansData.res.location }</p>
	<p>응답자 나이 : ${ansData.res.age }</p>
</body>
</html>