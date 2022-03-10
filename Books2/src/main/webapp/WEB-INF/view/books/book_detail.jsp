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
	<h1>도서정보관리-도서정보</h1>

	<c:if test="${!empty book }">
			<table border=1>
				<tr>
					<td rowspan='6'>
						 <img src="<c:url value='/resources/upload/${book.storedimagename}'/>" width="150" height="200"/>
					</td>
				</tr>

				<tr>
					<th>BOOK ISBN</th>
					<td>${book.isbn}</td>
				</tr>
				<tr>
					<th>도서명</th>
					<td>${book.bookname}</td>
				</tr>
				<tr>
					<th>저자</th>
					<td>${book.author}</td>
				</tr>
				<tr>
					<th>출판사</th>
					<td>${book.pubcompany}</td>
				</tr>
				<tr>
					<th>도서 가격</th>
					<td>${book.price}</td>
				</tr>
				<tr>
					<th>책 소개</th>
					<td colspan="2">${book.contents}</td>
				</tr>
			</table>
	</c:if>
	<button
		onClick="location.href='${pageContext.request.contextPath}/books/list'">도서정보
		목록</button>
</body>
</html>