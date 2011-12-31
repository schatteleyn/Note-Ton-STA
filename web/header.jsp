<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Note ton STA</title>
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="/js/highcharts.js" type="text/javascript"></script>
</head>
<body>
    <div class="topbar">
	<div class="fill">
    	<div class="container">
        	<span class="brand"><a href="<%= getServletContext().getContextPath() %>/home.jsp">Note Ton STA</a></span>
        	
			<ul class="nav">
			<c:choose>
			<c:when test="${ not empty userId }">
				<li><a href="<%= getServletContext().getContextPath() %>/myInterventions.jsp">My Interventions</a></li>
				<li><a href="<%= getServletContext().getContextPath() %>/newIntervention.jsp">New Intervention</a></li>
				<li><a href="<%= getServletContext().getContextPath() %>/logout.jsp">Logout</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="<%= getServletContext().getContextPath() %>/signup.jsp">Register</a></li>
			<li><a href="<%= getServletContext().getContextPath() %>/login.jsp">Login</a></li>
			</c:otherwise>
			</c:choose>
            	
          	</ul>
        </div>
    </div>
</div>