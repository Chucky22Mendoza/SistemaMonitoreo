<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
 
<!-- let's add tag srping:url -->
<spring:url value="/resources/prueba.css" var="CSS" />
<spring:url value="/resources/prueba.js" var="JS" />
<spring:url value="/resources/logo.png" var="logo" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="${pruebaCSS}" rel="stylesheet" />
<script src="${pruebaJS}"></script>
<!-- Finish adding tags -->
 
<title>Spring MVC Tutorial by Crunchify - Hello World Spring MVC Example</title>

</head>
<body>${message}
	<br>
	<div
		style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
 
		<h2>Checkout this font color. Loaded from 'crunchify.css' file under '/WebContent/resources/' folder</h2>
 
		<div id="msg"></div>
 
		<br> Spring MCV Tutorial by <a href="https://crunchify.com">Crunchify</a>.
 
		<br> <br> Click <a
			href="https://crunchify.com/category/java-tutorials/"
			target="_blank">here</a> for all Java and <a
			href='https://crunchify.com/category/spring-mvc/' target='_blank'>here</a>
		for all Spring MVC, Web Development examples.<br>
	</div>
        <img src='${logo}' width="200px">
</body>
</html>
