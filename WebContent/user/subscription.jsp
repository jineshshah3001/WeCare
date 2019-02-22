<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>GetSubscription</title>
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
<script type="text/javascript">


</script>
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
<!--[if lt IE 8]>
 <div style=' clear: both; text-align:center; position: relative;'>
   <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
     <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
   </a>
</div>
<![endif]-->
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<link rel="stylesheet" media="screen" href="css/ie.css">
<![endif]-->
</head>
<body>
<header>
  <div class="container_12" style="margin-bottom:-100px">
    <div class="grid_12" style="margin-top: 40px;">
  
      <h1 class="">
      <a href="index1.jsp" style="font-size: 75%;">
          WeCare
          </a>
      </h1>  
     </div>
    </div>
    
    </header>
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
<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<section id="content" style="height:700px"><div class="ic"></div>
  <div class="container_12">
  <!-- <form action="../AdminController" method="post">
   <button >Show Pending Approvals</button>
 </form> -->
    <div class="grid_8" style="height:30%; background-color:white;margin-left:40%">
      <div class="text1 tx__1">Subscription</div>
<form action="../subscriptionController" method="post">
<table>
<%-- <c:set value="${sessionScope.sList }" var="list"></c:set> --%>
<c:forEach var="i" items="${sessionScope.fetchedNGOs}" varStatus="index">
<tr><td>

<div class="form-check" class="p-3 mb-2 bg-info text-white">
  <label class="form-check-label"  class="bg-success text-white">
    <input class="form-check-input" type="checkbox"
    <%-- <c:if test="${i.active == 1}">checked="unchecked"</c:if> --%> 
    <c:if test="${i.active == 0}">checked="checked"</c:if> 
    value="${i.EIN}" name="EIN"/>
    ${i.name}
    
  </label>
</div>
</td></tr>
</c:forEach>

</table>
<button type="submit" class="btn btn-success">Subscribe</button>

</form>
</div>
</div>
</section>

<!--==============================
              footer
=================================-->
<footer id="footer">
  <div class="container_12">
    <div class="grid_12"> 
      <h1 class="logo">
        <a href="#">
          WECARE
        </a>

     
    <div class="clear"></div>
  </div>  
</footer>


<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>