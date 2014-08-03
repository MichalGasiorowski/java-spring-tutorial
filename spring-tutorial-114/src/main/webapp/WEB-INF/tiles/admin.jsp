<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Authorised users only.</h3>

<table class="formtable">
	<tr>
		<td>Username</td>
		<td>Email</td>
		<td>Role</td>
		<td>Enabled</td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td><c:out value="${user.username}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.authority}" /></td>
			<td><c:out value="${user.enabled}" /></td>
		</tr>
	</c:forEach>
</table>

