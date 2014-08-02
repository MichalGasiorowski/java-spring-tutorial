<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- this is ugly... but i will follow tutorial... -->

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 
	<form method="post" action="${pageContext.request.contextPath}/docreate"} class="formtable">
		<table>
			<tr>
				<td class="label">Name: <input name="name" type="text" class="control" /></td>
			</tr>
			<tr>
				<td class="label">Email: <input name="email" type="text" class="control"/></td>
			</tr>
			<tr>
				<td class="label">Offer text: <textarea rows="10" cols="10" class="control"></textarea></td>
			</tr>
			<tr>
				<td class="label"> <input value="Create advert" type="submit" class="control" /></td>
			</tr>
		</table>

	</form>
	-->
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" class="formtable" commandName="offer">
		<table>
			<tr>
				<td class="label">Name: <sf:input name="name" type="text" class="control" path="name"/><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email: <sf:input name="email" type="text" class="control" path="email"/><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Offer text: <sf:textarea rows="10" cols="10" class="control" name="text" path="text"></sf:textarea><br/><sf:errors path="text" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label"> <input value="Create advert" type="submit" class="control" /></td>
			</tr>
		</table>

	</sf:form>
	
</body>
</html>