<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="${pageContext.request.contextPath}/doCreate"}>
		<table>
			<tr>
				<td>Name: <input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>Email: <input name="email" type="text" /></td>
			</tr>
			<tr>
				<td>Offer text: <textarea rows="10" cols="30"></textarea></td>
			</tr>
			<tr>
				<td>Name: <input name="create advert" type="submit" /></td>
			</tr>
		</table>

	</form>
</body>
</html>