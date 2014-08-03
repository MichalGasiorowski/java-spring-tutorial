<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sf:form method="post"
	action="${pageContext.request.contextPath}/docreate" class="formtable"
	commandName="offer">
	<table>
		<tr>
			<td class="label">Name: <sf:input name="name" type="text"
					class="control" path="name" /><br />
			<sf:errors path="name" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label">Email: <sf:input name="email" type="text"
					class="control" path="email" /><br />
			<sf:errors path="email" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label">Offer text: <sf:textarea rows="10" cols="10"
					class="control" name="text" path="text"></sf:textarea><br />
			<sf:errors path="text" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label"><input value="Create advert" type="submit"
				class="control" /></td>
		</tr>
	</table>

</sf:form>

