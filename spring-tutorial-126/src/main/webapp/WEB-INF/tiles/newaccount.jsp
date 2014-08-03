<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Create new account</h2>
	<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" class="formtable" commandName="user">
		<table>
			<tr>
				<td class="label">Username: <sf:input name="username" type="text" class="control" path="username"/><br/><div class="error"><sf:errors path="username"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Name: <sf:input name="name" type="text" class="control" path="name"/><br/><div class="error"><sf:errors path="name"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Email: <sf:input name="email" type="text" class="control" path="email"/><br/><div class="error"><sf:errors path="email"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Password: <sf:input id="password" name="password" type="password" class="control" path="password"/><br/><div class="error"><sf:errors path="password"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Confirm password: <input id="confirmpass" name="confirmpass" type="password" class="control" /><div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label"> <input value="Create account" type="submit" class="control" /></td>
			</tr>
		</table>

	</sf:form>
