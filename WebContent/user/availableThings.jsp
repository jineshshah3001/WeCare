<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style_donate.css"> <!-- Resource style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/logout.css">

<link rel="stylesheet" href="css/description.css">

<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%-- <jsp:include page="header.jsp" /> --%>
<!-- <i style="color:white;font-size: 40px" class="fa fa-home"></i> -->
<br>
<br>
<a:set var="val1" value="${sessionScope.isUserLoggedIn}"></a:set>
			<a:set var="val2" value="yes"></a:set>
  <div class="container_12">
      <h1 class="">
      <a href="../homePageRedirectController" style="font-size: 75%;">
          WeCare
       </a>
      </h1> 
    </div>

  <form action="../loginController" method="GET">
   				<input class="logout" type="submit"  value="Logout"/>
				</form>
  
</head>
<body>
<form>
 
 <section class="cd-faq">
	<ul class="cd-faq-categories">
		<li><a class="selected" href="../ViewAvailableThingsController?param1=elec&display=no">Electronic</a></li>
		<li><a href="../ViewAvailableThingsController?param1=edu&display=no">Education</a></li>
		<li><a href="../ViewAvailableThingsController?param1=health&display=no">Health</a></li>
		<li><a href="../ViewAvailableThingsController?param1=hunger&display=no">Hunger</a></li>
		<li><a href="../ViewAvailableThingsController?param1=sports&display=no">Sports</a></li>
		<li><a href="../ViewAvailableThingsController?param1=household&display=no">Household</a></li>
		
	</ul> <!-- cd-faq-categories -->

<div class="cd-faq-items">
		<ul id="basics" class="cd-faq-group">
			<li class="cd-faq-title"></li>
			
			<a:set var="things" value="${sessionScope.things}" ></a:set>
			
			
			
			<a:set var="val1" value="[]"/>
			<a:set var="val2" value="${sessionScope.user }"/>
			
			
			<a:choose>
			<a:when test="${val1 != val2}">
 			<a:forEach var="i" items="${sessionScope.user}" varStatus="status">
			<li>
				<a class="cd-faq-trigger tooltip">${i[0].user_name } : 
				<a:if test="${sessionScope.category == 'elec' }">${things[status.index][0].electext}</a:if>
				<a:if test="${sessionScope.category == 'edu' }">${things[status.index][0].edutext}</a:if>
				<a:if test="${sessionScope.category == 'health' }">${things[status.index][0].healthtext}</a:if>
				<a:if test="${sessionScope.category == 'hunger' }">${things[status.index][0].hungertext}</a:if>
				<a:if test="${sessionScope.category == 'sports' }">${things[status.index][0].sportstext}</a:if>
				<a:if test="${sessionScope.category == 'household' }">${things[status.index][0].housetext}</a:if>
				<span class="classic">Contact details <br>Email ID : ${i[0].user_email }<br>Phone Number : ${i[0].user_number }</span>
				</a>
				 
				
				<div class="cd-faq-content">
				
									</div> <!-- cd-faq-content -->
			</li>
			</a:forEach>
			</a:when>
			<a:otherwise>
			<li>
				<a class="cd-faq-trigger"  target="_blank">N/A</a>
				<div class="cd-faq-content">
				</div> <!-- cd-faq-content -->
			</li>
			</a:otherwise>	
			</a:choose>
		</ul> 
</div> <!-- cd-faq-items -->
	<a href="#0" class="cd-close-panel">Close</a>
</section> <!-- cd-faq -->
<!-- <script src="js/jquery-2.1.1.js"></script> -->
<script src="js/jquery.mobile.custom.min.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->



</form>

<jsp:include page="footer.jsp" />

</body>
</html>