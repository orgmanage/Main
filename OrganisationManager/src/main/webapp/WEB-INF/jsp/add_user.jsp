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
<form:form action="create_user.htm" commandName="userModel"  enctype="multipart/form-data" method="post">
<table>
<tr>
<td class="label">First Name</td>
<td><form:input type="text" path="firstName" /></td>
</tr>
<tr>
<td class="label">Last Name</td>
<td><form:input type="text" path="lastName" /></td>
</tr>
<tr>
<td class="label">Address 1</td>
<td><form:input type="text" path="address1" /></td>
</tr>
<tr>
<td class="label">Address 2</td>
<td><form:input type="text" path="address2" /></td>
</tr>
<tr>
<td class="label">Blood Group</td>
<td><form:input type="text" path="bloodGroup" /></td>
</tr>
<tr>
<td class="label">City</td>
<td><form:input type="text" path="city" /></td>
</tr>
<tr>
<td class="label">State</td>
<td><form:input type="text" path="state" /></td>
</tr>
<tr>
<td class="label">Country</td>
<td><form:input type="text" path="country" /></td>
</tr>
<tr>
<td class="label">Date of Birth</td>
<td><form:input type="text" path="dateOfBirth" /></td>
</tr>
<tr>
<td class="label">Email Id</td>
<td><form:input type="text" path="emailId" /></td>
</tr>
<tr>
<td class="label">Emergency Contact</td>
<td><form:input type="text" path="emergContactNum" /></td>
</tr>
<tr>
<td class="label">Mobile Number</td>
<td><form:input type="text" path="mobileNumber" /></td>
</tr>
<tr>
<td class="label">Phone Number</td>
<td><form:input type="text" path="phoneNumber" /></td>
</tr>
<tr>
<td class="label">Fax Number</td>
<td><form:input type="text" path="faxNumber" /></td>
</tr>
<tr>
<td class="label">Pincode</td>
<td><form:input type="text" path="zipcode" /></td>
</tr>
<tr>
<td class="label">Username</td>
<td><form:input type="text" path="credential.userName" /></td>
</tr>
<tr>
<td class="label">Password</td>
<td><form:input type="text" path="credential.password" /></td>
</tr>
<tr>
<td class="label">Designation</td>
<td><form:select path="designation.designationId">
<form:option value="0" label="Select" />
<form:options items="${designations}" itemValue="designationId" itemLabel="designationName" />
</form:select></td>
</tr>
<tr>
<td class="label">Role</td>
<td><form:select multiple="true" path="userRoles">
<form:option value="0" label="" />
<form:options items="${roles}" itemValue="roleId" itemLabel="roleName" />
</form:select></td>
</tr>
<tr>
<td>User Image</td>
<td> <form:input type="file" path="userImage"/> </td>
</tr>
<tr>
<td colspan="2" ><form:button  type="submit" /> </td>
</tr>
</table>
</form:form>
</body>
</html>