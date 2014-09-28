<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Users</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<table>
<tr>
<td>User Id:</td>
<td>${userModel.userId}</td>
</tr>
<tr>
<td>First Name:</td>
<td>${userModel.firstName }</td>
</tr>
<tr>
<td>Last Name:</td>
<td>${userModel.lastName }</td>
</tr>
<tr>
<td>Address 1:</td>
<td>${userModel.address1}</td>
</tr>
<tr>
<td>Address 2:</td>
<td>${userModel.address2 }</td>
</tr>
<tr>
<td>Blood Group:</td>
<td>${userModel.bloodGroup }</td>
</tr>
<tr>
<td>City:</td>
<td>${userModel.city}</td>
</tr>
<tr>
<td>Country:</td>
<td>${userModel.country}</td>
</tr>
<tr>
<td>Date of Birth:</td>
<td>${userModel.dateOfBirth}</td>
</tr>
<tr>
<td>Email Id:</td>
<td>${userModel.emailId}</td>
</tr>
<tr>
<td>Emergency Contact:</td>
<td>${userModel.emergContactNum}</td>
</tr>
<tr>
<td>Mobile Number</td>
<td>${userModel.mobileNumber}</td>
</tr>
<tr>
<td>Phone Number:</td>
<td>${userModel.phoneNumber}</td>
</tr>
<tr>
<td>State:</td>
<td>${userModel.state}</td>
</tr>
<tr>
<td>Pincode:</td>
<td>${userModel.zipcode}</td>
</tr>
<tr>
<td>Designation:</td>
<td>${userModel.designation.designationName}</td>
</tr>
<tr>
<td>Role:</td>
<td>
<table>
<c:forEach items="${userModel.roles}" var="role">
<tr>
<td>Role Name:</td><td>${role.roleName }</td>
</tr>
<tr>
<td>Role Desc:</td><td>${role.roleDesc}</td>
</tr>
</c:forEach>
</table>
</td>
</tr>
</table>


</body>
</html>