<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
</head>
<body>
<c:if test="${not empty errorMessage}">
		<div>${errorMessage}</div> 
</c:if>
	<form:form method="POST" action="authenticate.htm" commandName="userModel" id="loginForm">
		<div style="width:300px;height:150px;">
		<table >
		<thead>
		<tr><th colspan="2">Organisation Login</th></tr>
		</thead>
		<tbody>
		<tr><td width="30%">User Name *</td><td><form:input path="credential.userName" style="width:150px;"/></td></tr>
		<tr><td width="30%">Password *</td><td><form:password path="credential.password" style="width:150px;"/></td></tr>
		<tr><td colspan="2">* marked fields are mandatory</td></tr>
		</tbody>
		<tfoot>
		<tr><td colspan="2"><button type="submit">Login</button></td></tr>
		</tfoot>
		</table>		
		</div>
				
	</form:form>	
</body>
</html>