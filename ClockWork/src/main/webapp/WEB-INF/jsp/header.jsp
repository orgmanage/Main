<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
	$("#logoutButton").click(function(){	
		location.replace('logout.htm');
	});
});
</script>
<div id="pageWrapper">
	<div id="capper"></div>
	<div id="header">
		<a href="#"><div id="logo"></div></a>		
		<c:if test="${sessionScope.org_user ne null}">
			<div id="loginInfo">
				<div id="lii_left">
					<div id="welcome">User - </div>
					<div id="name">${sessionScope.org_user.credential.userName} </div><br/>
				</div>
	
				<div id="lii_right">
					<button type="button" class="logout" id="logoutButton">
						Log out</button>
				</div>
				<br />
			</div><!-- loginInfo -->
		</c:if>
<!-- 
			<div class="notificationBox" id="notificationBox"><h2>Alert: <a href="alertdetails.shtml">details</a></h2><div id="notification">The customer's credit card has expired. There is more to this</div></div>
 -->
		<br>
		
		</div><!-- header -->	
		
