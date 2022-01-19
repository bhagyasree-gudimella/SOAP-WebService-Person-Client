<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/WEB-INF/views/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>View Persons List</title>
</head>
<body>
	<h2>Persons List</h2>
	<hr>
	<br>
	
	<table border="1" cellpadding="15"> 
			<tr>
				<th>Personal Information</th>
				<th>Contact Information</th>
				<th>Bank Information</th>
			</tr>
	
			<c:forEach var="person" items="${personsList}">
			<tr>
				<td>
						First name : <c:out value="${person.first_name}"></c:out> <br>
						Middle name : <c:out value="${person.middle_name}"></c:out> <br>
						Last name : <c:out value="${lperson.ast_name}"></c:out> <br>
						Email address : <c:out value="${person.email_address}"></c:out><br>
						Gender : <c:out value="${person.gender}"></c:out> <br>
					</td>
					
					<td>
						Address : <c:out value="${person.address}"></c:out> <br>
						City : <c:out value="${person.city}"></c:out> <br>
						State : <c:out value="${person.state}"></c:out> <br>
						Country : <c:out value="${person.country}"></c:out> <br>
						ZIPCODE : <c:out value="${person.zipcode}"></c:out> <br>
						Phone number : <c:out value="${person.phone_number}"></c:out> <br>
					</td>
					
					<td>
						Bank name : <c:out value="${person.bank_name}"></c:out> <br>
						Account details : <c:out value="${person.account_details}"></c:out> <br>
						SSN : <c:out value="${person.ssn_number}"></c:out> <br>
					</td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>