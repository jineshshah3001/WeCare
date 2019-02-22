<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@attribute name="extra_css" fragment="true" %>
<%@attribute name="extra_js" fragment="true" %>
<%@attribute name="body_code" fragment="true" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="css/reset.css">
		<link rel="stylesheet" href="css/style_donate.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="css/logout.css">
		
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/owl.carousel.css">
		<link rel="stylesheet" href="css/camera.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/button.css">
		<link rel="stylesheet" href="css/but.css">

		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.1.1.js"></script>
		<!-- <script src="js/signup.js"></script> -->
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/script.js"></script> 
		<script src="js/superfish.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<!-- <script src="js/tmStickUp.js"></script> -->
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/camera.js"></script>
		<script src="js/owl.carousel.js"></script> 
		<!--[if (gt IE 9)|!(IE)]><!-->
		<script src="js/jquery.mobile.customized.min.js"></script>
		<script src="js/modernizr.js"></script>
		<script src="js/main.js"></script>

		<!-- adding css & js from page those inherit header.tag : start-->
		<%-- <jsp:invoke fragment="extra_css"/>
		<jsp:invoke fragment="extra_js"/> --%>
		<!-- adding css & js from page those inherit header.tag : end-->

<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>

<a:set var="val1" value="${sessionScope.isUserLoggedIn}"></a:set>
<a:set var="val2" value="yes"></a:set>
<div class="container_12">
	<h1 class="">
		<a:if test="${val1 != val2}">
			<a href="index.jsp" style="font-size: 75%;"> ${title } </a>
		</a:if>
		<a:if test="${val1 == val2}">
			<a href="index1.jsp" style="font-size: 75%;"> ${title } </a>
		</a:if>
	</h1>
</div>
</head>
<body>
	<jsp:invoke fragment="body_code"/>
</body>
</html>