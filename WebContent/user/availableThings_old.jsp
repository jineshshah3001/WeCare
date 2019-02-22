<%-- <%@page import="java.awt.List"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Available Things</title>
<meta charset="utf-8">
<meta name = "format-detection" content = "telephone=no" />
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/script.js"></script> 
<script src="js/superfish.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.mobilemenu.js"></script>
<script src="js/tmStickUp.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<link rel="stylesheet" href="css/logout.css">
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/description.css">
<style>
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
}

button:hover {
    opacity: 0.8;
}
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}
/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
    border-radius: 10px;
}

.savebtn {
    width: auto;
    padding: 10px 18px;
    background-color: #4CAF50;
    border-radius: 10px;
}

.field_set {
        border: 1px solid #ccc;
    }
input[type="radio"]{
    -webkit-appearance: radio;
}

input[type="checkbox"] {
    -webkit-appearance: checkbox;
}
</style>
<script>



 $(window).load(function(){
  $().UItoTop({ easingType: 'easeOutQuart' });
  $('#stuck_container').tmStickUp({});  
 }); 
</script>
</head>

<body class="page1" id="top" onlaod="../volunteerController" method="post">
<!--==============================
              header
=================================-->
<header>
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
 
  <section id="stuck_container">
  <!--==============================
              Stuck menu
  =================================-->
    <div class="container_12">
        <div class="grid_12">          
          <div class="navigation ">
            <nav>
              <ul class="sf-menu">
               <%-- <li><a href="index.html">Home</a></li>
               <li class="current"><a href="about.html">About</a></li>
               <li><a href="mission.html">Mission</a></li>
               <li><a href="membership.html">Membership</a></li>
               <li><a href="contacts.html">Contacts</a></li> --%>
             </ul>
            </nav>
            <div class="clear"></div>
          </div>       
         <div class="clear"></div>  
     </div> 
     <div class="clear"></div>
    </div> 
  </section>
</header>
<!--=====================
          Content
======================-->

<section id="content" style="height:700px"><div class="ic"></div>
  <div class="container_12">
  <!-- <form action="../AdminController" method="post">
   <button >Show Pending Approvals</button>
 </form> -->
    <div class="grid_8" style="height:30%; background-color:white">
      <div class="text1 tx__1">Available Things</div>
   
    <div class="clear"></div>
    <div class="grid_approval">
    <div  id="Pending" name="pending">
    <%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
    
      <table width="100%" border="2" id="request">
 		<tr>
 		<td align="center"><fieldset style="color:black" class="field_set"><Legend><b></b></Legend><label for="EIN"><b>User Details</b></label>
 			</fieldset></td>
 			<td align="center"><fieldset  style="color:black" class="field_set"><Legend><b></b></Legend><label for="Name"><b>Available Things</b></label>
 			</fieldset></td>
 			
 			
 		</tr>
 		 <a:set var="things" value="${sessionScope.things}" ></a:set>
 		
 		<a:forEach var="i" items="${sessionScope.user}" varStatus="status">
 		<tr style="border:1px solid #ccc">
 		
 		<td align="center"><p> 
 			<a class="tooltip" href="#">${i[0].user_name}
 				<span class="classic">Contact details <br>Email ID : ${i[0].user_email }<br>Phone Number : ${i[0].user_number }</span>
 			</a>
 		</td> 
 		<td align="center">
 			<a:if test="${things[status.index][0].elec == 1}">Electronics: ${things[status.index][0].electext}<br>  </a:if>
 			<a:if test="${things[status.index][0].edu == 1}">Education: ${things[status.index][0].edutext}<br>  </a:if>
 			<a:if test="${things[status.index][0].health == 1}">Health: ${things[status.index][0].healthtext}<br>  </a:if>
 			<a:if test="${things[status.index][0].hunger == 1}">Hunger: ${things[status.index][0].hungertext}<br>  </a:if>
 			<a:if test="${things[status.index][0].sports == 1}">Sports: ${things[status.index][0].sportstext}<br> </a:if>
 			<a:if test="${things[status.index][0].household == 1}">Household: ${things[status.index][0].housetext}<br>  </a:if>
 			<a:if test="${not empty things[status.index][0].other}">Other: ${things[status.index][0].other}</a:if>
 		</td>
 		
 		</tr>
    	</a:forEach>
 		 
			
			
			</table>
	</div>
    <div class="clear" style="height:30%; background-color:white" ></div>
    <div class="grid_12" style="height:30%; background-color:white" >
      <%-- <div class="block-4">
        <div class="block-4_title">Life Group</div>Amus at magna non nunc tristique rhoncus. Aliquam nibh antegestas id dictum a, commodo luctus libero. Praesent faucibus malesuada faucibus. Donec laoreet metus id laoreeto alesuada. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur orci sed 
        <a href="#">Learn <br> More</a>
      </div> --%>
    </div>
    <div class="clear"></div>
     </div>
  </div>
   <div class="clear"></div>
  </div>
  
</section>
<!--==============================
              footer
=================================-->
<footer id="footer">
  <div class="container_12">
    <div class="grid_12"> 
      <h1 class="logo">
        <a href="index.html">
          WECARE	
        </a>
      </h1>
      <div class="socials">
        <a href="#" class="fa fa-twitter"></a>
        <a href="#" class="fa fa-facebook"></a>
        <a href="#" class="fa fa-google-plus"></a>
        <a href="#" class="fa fa-pinterest"></a>
      </div>
     
    <div class="clear"></div>
  </div>  
</footer>
<a href="#" id="toTop" class="fa fa-angle-up"></a>
</body>
</html>

