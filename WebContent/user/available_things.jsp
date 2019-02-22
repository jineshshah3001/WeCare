<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Available Things</title>
<meta charset="utf-8">
<meta name = "format-detection" content = "telephone=no" />
 <meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

<body class="page1" id="top" onlaod="../AdminController" method="post">
<!--==============================
              header
=================================-->
<header>
<div class="container_12">
    <div class="grid_12" style="margin-bottom: -35px; margin-top: 20px;">
  
      <h1 class="">
      	<a href="index1.jsp" style="font-size: 75%;">
          WeCare
        </a>
      </h1>  
   </div>
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

<section id="content" style="height:700px"><div class="ic">More Website Templates @ TemplateMonster.com - September22, 2014!</div>
  <div class="container_12">
  <!-- <form action="../AdminController" method="post">
   <button >Show Pending Approvals</button>
 </form> -->
    <div class="grid_8" align="center" style="height:30%; background-color:white">
      
   
    <div class="clear"></div>
    <div class="grid_approval">
<div class="grid_8" style="height:30%; background-color:white">
      <div class="text1 tx__10" style="margin-left:50%">Add Available Things</div>
<form method="POST" action="../AvailableThingsController">
<table style="margin-left:60%">
<tr>
<td>
<input style="margin-left: -30%"type="checkbox" name="electronics" id="electronics" value="Electronics" 
  	id="all1" <a:if test="${key_list[0].elec == 1}">checked="checked"</a:if>  
  	onchange="document.getElementById('btn').disabled = !this.checked;"/>
  <span class="checkmark"></span> 
<label class="container" >Electronics
  
  </label>
  </td><td>
  <input  style="color:black; margin-right:20%" name="electext" id="electext" type="text" placeholder="Enter item" readonly=true value="${key_list[0].electext}" >
  

</td>
</tr>
<tr><td align="center">

  <input style="margin-left: -45%" type="checkbox" name="education" id="education" value="Education"  
  id="all2"<a:if test="${key_list[0].edu == 1}">checked="checked"</a:if>
  onchange="document.getElementById('btn').disabled = !this.checked;"/>
  
  <span class="checkmark"></span>
  <label class="container" >Education
  </label>
  </td><td>
  <input  style="color:black" id="edutext" name="edutext" type="text" placeholder="Enter item" readonly=true value="${key_list[0].edutext}" >
</td>
</tr>
<tr><td align="center">
  <input style="margin-left: -75%" type="checkbox" name="health" id="health" value="Health"  
  id="all3"<a:if test="${key_list[0].health == 1}">checked="checked"</a:if>
  onchange="document.getElementById('btn').disabled = !this.checked;"/>
  <span class="checkmark"></span>
  <label class="container" >Health</label>
  </td><td>
  <input  style="color:black" id="healthtext" name="healthtext" type="text" placeholder="Enter item" readonly=true value="${key_list[0].healthtext}" >
</td>
</tr>
<tr><td align="center">

  <input style="margin-left: -68%" type="checkbox" name="hunger" id="hunger" value="Hunger"  
  id="all4"<a:if test="${key_list[0].hunger == 1}">checked="checked"</a:if>
  onchange="document.getElementById('btn').disabled = !this.checked;"/>
  <span class="checkmark"></span>
  <label class="container" >Hunger</label>
  </td><td>
  <input  style="color:black" id="hungertext" name="hungertext" type="text" placeholder="Enter item" readonly=true  value="${key_list[0].hungertext}" >
</td>
</tr>
<tr><td align="center">
  <input  style="margin-left: -75%" type="checkbox" name="sports" id="sports" value="Sports" 
  id="all5"<a:if test="${key_list[0].sports == 1}">checked="checked"</a:if>
  onchange="document.getElementById('btn').disabled = !this.checked;"/>
  <span class="checkmark"></span>
  <label class="container" >Sports</label>
  </td><td>
  <input  style="color:black" id="sportstext" name="sportstext" type="text" placeholder="Enter item" readonly=true value="${key_list[0].sportstext}" >
</td>
</tr>
<tr><td align="center">
  <input style="margin-left: -40%" type="checkbox" name="household" id="household" value="Household"  
  id="all6"<a:if test="${key_list[0].household == 1}">checked="checked"</a:if>
  onchange="document.getElementById('btn').disabled = !this.checked;"/>
  <span class="checkmark"></span>
  <label class="container">Household</label>
  </td><td>
  <input  style="color:black" id="housetext" name="housetext" type="text" placeholder="Enter item" readonly=true value="${key_list[0].housetext}" >
</td>
</tr>
<tr>
<td><label style="color:black" for="url"><b>Other</b></label></td>
<td>
      <input  style="color:black" type="text" placeholder="Enter other" name="other" value="${key_list[0].other}" >
</td>
</tr>
<tr><td></td>
<td align="center">
<div class="popup" <a:if test="${fn:length(key_list) gt 0}">style="display:none"</a:if>>
<button style="padding: 14px 32px;margin-right:50%;"  class="button" onclick="myFunction()" id="btn" <a:if test="${fn:length(key_list) eq 0}">disabled="disabled"</a:if>>Submit </button>
 <div id="check" style="display:none"> <span class="popuptext" id="myPopup">Successfully Submitted</span></div>
</div>
</td>
</tr>
<tr><td></td>
<td align="center">
<div class="popup" <a:if test="${fn:length(key_list) eq 0}">style="display:none"</a:if>>
<button style="padding: 14px 32px;margin-right:50%;" class="button" onclick="myFunction1()">Update </button>
  <div id="check1" style="display:none"><span class="popuptext" id="myPopup1">Successfully Updated</span> </div>
</div>
</td>
</tr>
</table >
<a:if test="${fn:length(key_list) eq 0}">
<input type="hidden" name="hiddenBtn" value="submitBtn"/>
</a:if>
<a:if test="${fn:length(key_list) gt 0}">
<input type="hidden" name="hiddenBtn" value="updateBtn"/>
</a:if>
<script>
	

	//document.getElementById(textBoxID).disabled = !document.getElementById(checkbox).checked;
   $('#electronics').change(function(){
    	 var check = document.getElementById("electronics").checked;
    	 if(check){
    		 $("#electext").prop('readonly', false);
    	 }else{
    		 document.getElementById("electext").value="";
    		 $("#electext").prop('readonly', true);
    	 }
    	 
     });
	$('#education').change(function(){
		var check = document.getElementById("education").checked;
    	 if(check){
    		 $("#edutext").prop('readonly', false);
    	 }else{
    		 document.getElementById("edutext").value="";
    		 $("#edutext").prop('readonly', true);
    	 }
    	 
     });
	
     
     $('#health').change(function(){
    	 var check = document.getElementById("health").checked;
    	 if(check){
    		 $("#healthtext").prop('readonly', false);
    	 }else{
    		 document.getElementById("healthtext").value="";
    		 $("#healthtext").prop('readonly', true);
    	 }
    	 
     });
     $('#hunger').change(function(){
    	 var check = document.getElementById("hunger").checked;
    	 if(check){
    		 $("#hungertext").prop('readonly', false);
    	 }else{
    		 document.getElementById("hungertext").value="";
    		 $("#hungertext").prop('readonly', true);
    	 }
    	 
     });
     $('#sports').change(function(){
    	 var check = document.getElementById("sports").checked;
    	 if(check){
    		 $("#sportstext").prop('readonly', false);
    	 }else{
    		 document.getElementById("sportstext").value="";
    		 $("#sportstext").prop('readonly', true);
    	 }
    	 
     });
     $('#household').change(function(){
    	 var check = document.getElementById("household").checked;
    	 if(check){
    		 $("#housetext").prop('readonly', false);
    	 }else{
    		 document.getElementById("housetext").value="";
    		 $("#housetext").prop('readonly', true);
    	 }
    	 
     });


// When the user clicks on div, open the popup
function myFunction() {
	var check=document.getElementById("check");
	check.style.display='inline';
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
}
function myFunction1() {
	var check1=document.getElementById("check1");
	check1.style.display='inline';
    var popup = document.getElementById("myPopup1");
    popup.classList.toggle("show");
}
</script>

</form>
    
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

