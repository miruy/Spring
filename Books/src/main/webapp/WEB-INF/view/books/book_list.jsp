<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
</head>
<body>
	<h1>도서정보관리-리스트</h1>

	<form:form method="get" action="search" commandName="searchCmd">
		<P>
			검색 키워드 입력 : 
			<select name="option">
				<option value="bookname">제목</option>
				<option value="author">저자</option>
				<option value="pubcompany">출판사</option>
			</select> 
			
			<input type="text" name="keyword" placeholder="제목, 저자 또는 출판사 검색" size=30> 
			<input type="submit" value="찾기">
		</P>
	</form:form>
	
	<c:if test="${!empty books}">
		<table border="1">
			<tr>
				<th>등록 번호</th>
				<th>도서 표지</th>
				<th>도서 ISBN</th>
				<th>도서 제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
			
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.id}</td>
					
					<td>
					<img src="<c:url value='/resources/upload/${book.storedimagename}'/>" width="150" height="200"/>
					</td>
					
					<td>${book.isbn}</td>
					<td>
						<a href="${pageContext.request.contextPath}/books/read/${book.id}">
							${book.bookname}
						</a>
					</td>

					<td>${book.author}</td>
					<td>${book.pubcompany}</td>
					<td>${book.price}</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>	
			
		<c:if test="${!empty searchBook }">
		<table border="1">
			<tr>
				<th>등록 번호</th>
				<th>도서 표지</th>
				<th>도서 ISBN</th>
				<th>도서 제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
			<c:forEach var="book" items="${searchBook}">
				<tr>
					<td>${book.id}</td>
					
					<td>
					<img src="<c:url value='/resources/upload/${book.storedimagename}'/>" width="150" height="200"/>
					</td>
					
					<td>${book.isbn}</td>
					<td>
						<a href="${pageContext.request.contextPath}/books/read/${book.id}">
							${book.bookname}
						</a>
					</td>

					<td>${book.author}</td>
					<td>${book.pubcompany}</td>
					<td>${book.price}</td>
				</tr>
			</c:forEach>
			</table>
			</c:if>
	
	<button onClick="location.href='${pageContext.request.contextPath}/books/add'">
		도서정보 추가
	</button>


</body>
</html>