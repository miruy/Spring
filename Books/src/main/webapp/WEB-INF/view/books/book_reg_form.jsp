<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#file").on('change', function(){
                readURL(this);
            });
        });
        function readURL(input) {
            if (input.files && input.files[0]) {
               var reader = new FileReader();
               reader.onload = function (e) {
                  $('#preview').attr('src', e.target.result);
               }
               reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</head>
<body>
	<form:form method="post" commandName="bookCmd" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td colspan="3" style="text-align: right;"><span style="color: red;">*</span>표시는 필수입니다.</td>
			</tr>
			<tr>
				<td rowspan='7'>
   					  <img id="preview" src="${pageContext.request.contextPath}/resources/upload/${book.storedimagename}" width="150" height="200" />
				</td>
			</tr>

			<tr>
				<th style="text-align: left;"><span style="color: red;">*</span>BOOK ISBN</th>
				<td>
				<input type="text" name="isbn"/>
				<form:errors path="isbn"/>
				</td>
			</tr>
			<tr>
				<th style="text-align: left;"><span style="color: red;">*</span>도서명</th>
				<td>
				<input type="text" name="bookname">
				<form:errors path="bookname"/>
				</td>
			</tr>
			<tr>
				<th style="text-align: left;"><span style="color: red;">*</span>저자</th>
				<td>
				<input type="text" name="author">
				<form:errors path="author"/>
				</td>
			</tr>
			<tr>
				<th style="text-align: left;"><span style="color: red;">*</span>출판사</th>
				<td>
				<input type="text" name="pubcompany">
				<form:errors path="pubcompany"/>
				</td>
			</tr>
			<tr>
				<th style="text-align: left;"><span style="color: red;">*</span>도서 가격</th>
				<td>
				<input type="text" name="price">
				<form:errors path="price"/>
				</td>
			</tr>
			<tr>
				<th style="text-align: left;"><span style="color: red;">*</span>이미지</th>
				<td>
					<input type="file" name="file" id="file">
					<form:errors path="file"/>
				</td>
			</tr>
			<tr>
				<th style="text-align: left;"><span style="color: red;">*</span>책 소개</th>
				<td colspan="2">
				<textarea name="contents" rows="13" cols="40"></textarea>
				<form:errors path="contents"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="도서정보 추가">
		<button
			onClick="location.href='${pageContext.request.contextPath}/books/list'">도서정보
			목록</button>
	</form:form>
</body>
</html>

