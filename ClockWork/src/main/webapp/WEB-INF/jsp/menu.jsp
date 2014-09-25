<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="menus">
<div id="menuSheath">	 
	 <div id="menu_home" class="menu">
		<a id="link_menu_home" href="./home.htm" class="">Home</a>
		<ul></ul>
	</div>
	<div id="menu_myInfo" class="menu">
		<a id="link_menu_myInfo" href="./myInfo.htm" class="">My Info</a>
		<ul></ul>
	</div>
	<div id="menu_manage_users" class="menu">
		<a id="link_menu_manage_users" href="./manage_users.htm" class="">Manage Users</a>
		<ul></ul>
	</div>
	<div id="menu_reports" class="menu">
		<a id="link_menu_reports" href="./reports.htm" class="">Reports</a>
		<ul></ul>
	</div>
	<div id="menu_support" class="menu">
		<a id="link_menu_support" href="./support.htm" class="">Support</a>
		<ul></ul>
	</div> 						
</div>		
	<br>
</div>

<script type="text/javascript">    
    $(document).ready( function() {
    		$('#menu_${menu_item}').removeClass('menu').addClass('menu home');
    		$('#link_menu_${menu_item}').addClass('there');
    });
    
</script> 