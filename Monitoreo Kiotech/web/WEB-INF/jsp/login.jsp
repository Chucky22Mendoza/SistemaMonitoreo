<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- let's add tag srping:url -->
    <spring:url value="/resources/css/bootstrap/bootstrap.min.css" var="btCSS" />
    <spring:url value="/resources/css/login.css" var="login" />
    <spring:url value="/resources/images/logo.png" var="logo" />
    <spring:url value="/resources/alertifyjs/css/alertify.css" var="alertifyCSS" />
    <spring:url value="/resources/css/spinner.css" var="spinnerCSS" />
    <spring:url value="/resources/js/jquery.js" var="jquery" />
    <spring:url value="/resources/js/bootstap/bootstrap.min.js" var="btJS" />
    <spring:url value="/resources/js/sesion.js" var="sesion" />
    <spring:url value="/resources/js/spinner.js" var="spinnerJS" />
    <spring:url value="/resources/alertifyjs/alertify.js" var="alertifyJS" />

    <link rel="shortcut icon" href="${logo}">
    <link rel="stylesheet" href="${btCSS}">
    <link rel="stylesheet" href="${login}">
    <link rel="stylesheet" href="${alertifyCSS}">
    <link rel="stylesheet" href="${spinnerJS}">
    <!-- Finish adding tags -->
    <meta charset="utf-8">
    <title>LOGIN</title>
  </head>
  <body>
  <form id="formLogIn">
      <img src="${logo}" width="200px" class="mt-5">

    <input type="text" class="mt-5" id= "user" maxlength="50" name="user" placeholder="&#128187; Usuario" >
    <input type="password" id= "pass" maxlength="20" name="pass" placeholder="&#128272; Contraseña" >
    <button id="btnLogIn">Iniciar Sesión</button>

  </form>

    <script src="${jquery}"></script>
    <script src="${btJS}"></script>
    <script src="${alertifyJS}"></script>
    <script src="${spinnerJS}"></script>
    <script src="${sesion}"></script>
  </body>
</html>
