<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tagExample" tagdir="/WEB-INF/tags" %>
<tagExample:header title="We CARE">

	<jsp:attribute name="body_code">
		
			<a:set var="val1" value="${sessionScope.isUserLoggedIn}"></a:set>
			<a:set var="val2" value="yes"></a:set>
				<a:if test="${val1 == val2}">
				<form action="../loginController" method="GET">
   				<input class="logout" type="submit"  value="Logout"/>
				</form>
				</a:if>

<form><!--  method="post" action="../userdonateController" -->
 
 <section class="cd-faq">
	<ul class="cd-faq-categories">
		<li><a class="selected" href="../userdonationController?param1=elec">Electronic</a></li>
		<li><a href="../userdonationController?param1=edu">Education</a></li>
		<li><a href="../userdonationController?param1=health">Health</a></li>
		<li><a href="../userdonationController?param1=hunger">Hunger</a></li>
		<li><a href="../userdonationController?param1=sports">Sports</a></li>
		<li><a href="../userdonationController?param1=household">Household</a></li>
		
	</ul> <!-- cd-faq-categories -->

	<div class="cd-faq-items">
		<ul id="basics" class="cd-faq-group">
			<li class="cd-faq-title"></li>
			
			<a:set var="val1" value="[]"/>
			<a:set var="val2" value="${sessionScope.key }"/>
			
			
			<a:choose>
			<a:when test="${val1 != val2}">
			<a:forEach var="i" items="${sessionScope.key}">
			<li>
				<a class="cd-faq-trigger" href=${i.URL } target="_blank">${i.name }</a>
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
		</ul> <!-- cd-faq-group -->

	</div> <!-- cd-faq-items -->
	<a href="#0" class="cd-close-panel">Close</a>
</section> <!-- cd-faq -->
</form>
		
	</jsp:attribute>

</tagExample:header>
