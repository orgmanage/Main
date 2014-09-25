<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<style type="text/css" title="currentStyle">
		@import "${contextPath}/resources/css/orgmanager.css";		
		@import "${contextPath}/resources/css/jquery.dataTables.css";
		@import "${contextPath}/resources/css/jquery.ui.css";
		@import "${contextPath}/resources/css/bvalidator.css";	
		@import "${contextPath}/resources/css/structure.css";	
	</style>
	
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.blockUI.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.dataTables.js"></script>	
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.ui.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/org_manager.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.bvalidator.js"></script>
	<script>
	$(document).ready(function() {

		$('div.exportlinks a').each(function() {
			var exportOption = $.trim($(this).text());
			var exportOptionTitle = 'Export';
			if (exportOption == 'CSV') {
				exportOptionTitle = '<fmt:message key="export.csv.title" />';
			} else if (exportOption == 'Excel') {
				exportOptionTitle = '<fmt:message key="export.excel.title" />';
			} else if (exportOption == 'XML') {
				exportOptionTitle = '<fmt:message key="export.xml.title" />';
			} else if (exportOption == 'PDF') {
				exportOptionTitle = '<fmt:message key="export.pdf.title" />';
			} else if (exportOption == 'RTF') {
				exportOptionTitle = '<fmt:message key="export.rtf.title" />';
			}
			$(this).attr('title', exportOptionTitle);
		});

		var exportOnTop = $('div.exportlinks').html();		
		$('#exportLinksOnTop').html(exportOnTop);	
		$('div.exportlinks').hide();
	});
	</script>
</head>
<body>
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="menu" />
	<div id="bodyWrap">	
		<div id="bodyContent" style="margin:0 auto;">		
			<tiles:insertAttribute name="body" />
		</div><!-- bodyContent -->
	</div><!-- bodyWrap -->
	<tiles:insertAttribute name="footer" />
</body>
</html>