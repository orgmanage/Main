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
	var $dialog = $("#userDetails").dialog({
        autoOpen: false,
        title: 'User Details',
        width: 500,
        height: 300
    });
	
	$("#searchString").catcomplete({
		delay:0,
		source:function(request,response){
			$.ajax({ 
		        type: 'POST', 
		        url: 'search_user.htm', 
		        data: { searchString: $("#searchString").val().toLowerCase() },
		        dataType:'json',
		        success: function (data) { 
		        	response(data);
		        },
		        error: function(result){
		        	alert("Error ");
		        }
		    });
		},
		minlength:0,
		open: function() {
	    },
	    close: function() {
	    },
	    focus:function(event,ui) {
	    },
	    select: function( event, ui ) {
            $.ajax({ 
		        type: 'GET', 
		        url: 'user_details.htm', 
		        data: { userId: ui.item.value },
		        success: function (data) { 
		        	$("#userDetails").html(data);
		        	$dialog.dialog("open");
		        },
		        error: function(result){
		        	alert("Error ");
		        }
		    });
            return false;
	    }
	});
});
</script>
</head>
<body>

<form method="POST" action="search_user.htm" id="searchForm">
<label>Search Users: </label>
<input id="searchString" />
<div id="userDetails" style="display:none;"></div>
</form>
</body>
</html>