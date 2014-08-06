<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

function onDeleteClick(event) {
	
	var doDelete = confirm("Are you sure to delete offer?");
	if(doDelete == false) {
		event.preventDefault(); <!-- prevents the default behaviour-->
	}
	
}
	function onReady() {
		$("#delete").click(onDeleteClick);
	}

	$(document).ready(onReady);
</script>

<sf:form method="post"
	action="${pageContext.request.contextPath}/docreate" class="formtable"
	commandName="offer">
	<sf:input name="id" path="id" type="hidden" />
	<table>
		<tr>
			<td class="label">Offer text: <sf:textarea rows="10" cols="10"
					class="control" name="text" path="text"></sf:textarea><br /> <sf:errors
					path="text" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label"><input value="Save advert" type="submit"
				class="control" /></td>
		</tr>
		<c:if test="${offer.id ne 0}">
			<tr>
				<td class="label"></td>
				<td>&nbsp;
				<td>
			</tr>
			<tr>
				<td class="label"><input name="delete" class="delete" id="delete"
					value="Delete this offer." type="submit" class="control" /></td>
			</tr>
		</c:if>
	</table>

</sf:form>

