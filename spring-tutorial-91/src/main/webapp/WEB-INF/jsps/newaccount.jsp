<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- this is ugly... but i will follow tutorial... -->

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.11.1.min.js"></script>
<script type="text/javascript" >

function onLoad() {
	
	$("#password").keyup(checkPasswordsMatch);
	$("#confirmpass").keyup(checkPasswordsMatch);

	$("#details").submit(canSubmit);
}

function canSubmit() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	if(password != confirmpass) {
		alert("<fmt:message key='UnmatchedPasswords.user.password' />");
		return false;
	} else {
		return true;
	}
}

function checkPasswordsMatch() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	if(password.length < 3) {
		$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
		return;
	}
	
	if(password == confirmpass) {
		$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' />");
		$("#matchpass").addClass("valid");
		$("#matchpass").removeClass("error");
	} else {
		$("#matchpass").text();
		$("#matchpass").addClass("error");
		$("#matchpass").removeClass("valid");
	}
	
}

$(document).ready(onLoad);

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create user</title>
</head>
<body>


<h2>Create new account</h2>
	<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" class="formtable" commandName="user">
		<table>
			<tr>
				<td class="label">Username: <sf:input name="username" type="text" class="control" path="username"/><br/><div class="error"><sf:errors path="username"></sf:errors></div></td>
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
	
</body>
</html>