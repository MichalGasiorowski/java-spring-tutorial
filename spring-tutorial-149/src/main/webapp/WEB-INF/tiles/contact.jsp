<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>Send message</h2>

<sf:form method="post" class="formtable" commandName="message">

	<input type="hidden" name="_flowExecutionKey"
		value="${flowExecutionKey}" />
	<input type="hidden" name="_eventId"
		value="send" />

	<table>
		<tr>
			<td class="label">Your name: <sf:input name="subject"
					type="text" class="control" path="name" value="${fromName}"/><br />
				<div class="error">
					<sf:errors path="name"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your email: <sf:input name="email" type="text" 
					class="control" path="email" value="${fromEmail}"/><br />
				<div class="error">
					<sf:errors path="email"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Subject: <sf:input name="subject" type="text"
					class="control" path="subject" /><br />
				<div class="error">
					<sf:errors path="subject"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your Message: <sf:textarea name="content"
					type="text" class="control" path="content" /><br />
				<div class="error">
					<sf:errors path="content"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label"><input value="Save message" type="submit"
				class="control" /></td>
		</tr>
	</table>

</sf:form>
