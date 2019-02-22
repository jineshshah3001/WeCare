<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script type="text/javascript">
function validateDate(){
	var userdate=new Date(document.getElementById("myDate").value);
	var today=new Date();
	if(userdate<today){
		alert("Select Proper Date");
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet" href="css/style_donate.css">
<!-- Resource style -->
<script src="js/modernizr.js"></script>
<!-- Modernizr -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/logout.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
<script src="js/jquery.mobile.custom.min.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
<title>Insert title here</title>
<br>
<br>
<div class="container_12">
      <h1 class="">
      <a href="../homePageRedirectController" style="font-size: 75%;">
          WeCare
          </a>
      </h1>  
</div>
</head>	
<body style="text-align:center;">
  <form action="../loginController" method="GET">
   				<input class="logout" type="submit"  value="Logout"/>
				</form>

<br>
<br>
<div style="margin-left:100px;width:600px;border:2px solid white;margin-right: 345px;">
<form action="${pageContext.request.contextPath}/CreateEventController" method="post">
  <a:set var="val1" value="null"/>
			<a:set var="val2" value="${sessionScope.eventToUpdate}"/>
			
			<a:choose>
			
			<a:when test="${val1 != val2}">
			
			
			<input type="hidden" name="flag" value="${eventToUpdate[0].event_id}" /> 
			  <div class="form-group row">
    <label for="eventname" class="col-sm-3 col-form-label" style="color:white">Event Name</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" placeholder="Event Name" <a:if test="${eventToUpdate[0].active == 0}"> readonly="readonly"</a:if>  name="event_name" value="${eventToUpdate[0].event_name}" required>
    </div>
    </div>
  
  <div class="form-group row">
    <label for="location" class="col-sm-3 col-form-label" style="color:white" >Location</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" placeholder="Location" <a:if test="${eventToUpdate[0].active == 0}"> readonly="readonly"</a:if> name="location" value="${eventToUpdate[0].location}" required >
    </div>
    </div>
  
  <div class="form-group row">
    <label for="time" class="col-sm-3 col-form-label" style="color:white">Time</label>
    <div class="col-sm-6">
    <input type="time" class="form-control" name="time" value="${eventToUpdate[0].time}" <a:if test="${eventToUpdate[0].active == 0}"> readonly="readonly"</a:if> required>
    </div>
    </div>
  
  <div class="form-group row">
    <label for="date" class="col-sm-3 col-form-label" style="color:white">Date</label>
    <div class="col-sm-6">
    <input type="date" class="form-control" id="myDate" name="date" <a:if test="${eventToUpdate[0].active == 0}"> readonly="readonly"</a:if> onchange="validateDate()" value="${eventToUpdate[0].date}" required>
    </div>
    </div>
  
  <div class="form-group row">
    <label for="description" class="col-sm-3 col-form-label" style="color:white">Description</label>
    <div class="col-sm-6">
    <textarea name="description" rows=4 cols=50 class="form-control" <a:if test="${eventToUpdate[0].active == 0}"> readonly="readonly"</a:if>  required >${eventToUpdate[0].description}</textarea>
    </div>
    </div>
    <a:if test="${eventToUpdate[0].active == 1}">
	 	<input type="submit" name="btn" class="btn btn-primary" value="Update"/>
  		<input type="submit" name="btn" class="btn btn-primary" value="Inactive Event">
	</a:if>
	<a:if test="${eventToUpdate[0].active == 0}">
		<input type="submit" name="btn" class="btn btn-primary" value="Active Event">
	</a:if>

			
			</a:when>
			<a:otherwise>  
  
  <div class="form-group row">
    <label for="eventname" class="col-sm-3 col-form-label" style="color:white">Event Name</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" placeholder="Event Name"  name="event_name" required>
    </div>
    </div>
  
  <div class="form-group row">
    <label for="location" class="col-sm-3 col-form-label" style="color:white">Location</label>
    <div class="col-sm-6">
    <input type="text" class="form-control" placeholder="Location" name="location" required >
    </div>
    </div>
  
  <div class="form-group row">
    <label for="time" class="col-sm-3 col-form-label" style="color:white">Time</label>
    <div class="col-sm-6">
    <input type="time" class="form-control" name="time" required>
    </div>
    </div>
  
  <div class="form-group row">
    <label for="date" class="col-sm-3 col-form-label" style="color:white">Date</label>
    <div class="col-sm-6">
    <input type="date" class="form-control" id="myDate" name="date" onchange="validateDate()" required>
    </div>
    </div>
  
  <div class="form-group row">
    <label for="description" class="col-sm-3 col-form-label" style="color:white">Description</label>
    <div class="col-sm-6">
    <textarea name="description" rows=4 cols=50 maxlength=250  class="form-control" required></textarea>
    </div>
    </div>

  <input type="submit" name="btn" class="btn btn-primary" value="Save"/>
  <!-- <input type="submit" name="btn" class="btn btn-primary" value="Reset" > -->
  <input type="hidden" name="flag" value="0">
  </a:otherwise>
  </a:choose>
</form>
</div>
<br>
<div style="margin-top:-420px;margin-right:10px;width:500px;border:2px solid yellow;float:right">
<ul id="basics" class="cd-faq-group">		
 		<a:forEach var="i" items="${sessionScope.events}">
			<li>
				<a class="cd-faq-trigger" href="../CreateEventController?eventid=${i.event_id }"> 
				${i.event_name} <a:if test="${i.active == 0}">: Inactive</a:if>
				
				</a>
			</li>
		</a:forEach>
 </ul> 
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>