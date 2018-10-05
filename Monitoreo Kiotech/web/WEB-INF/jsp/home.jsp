<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <spring:url value="/resources/js/jquery.js" var="jquery" />
        <spring:url value="/resources/js/home.js" var="home" />
        <spring:url value="/resources/css/home.css" var="homeCSS" />
        <spring:url value="/resources/images/logo.png" var="logo" />
        <spring:url value="/resources/images/home.png" var="homeIMG" />
        <spring:url value="/resources/css/bootstrap/bootstrap.min.css" var="btCSS" />
        
        <link rel="stylesheet" href="${homeCSS}">
        <link rel="shortcut icon" href="${logo}">
        <link rel="shortcut icon" href="${homeIMG}">
        <link rel="stylesheet" href="${btCSS}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
    
        
    </head>

    <body>
         <script src="${jquery}"></script>
         <script src="${home}"></script>
         
    <header>
        <div style="text-align:center">
        <nav><img src="${logo}" width="200px" class="mt-5"> </nav>  
        </div>
        <nav> 
               <img src="${homeIMG}" width="50px" class="mt-5"> 
               <button id="btnMonitoreo">Monitoreo de Kisko</button> 
               <button id="btnAlerta"> Alertas </button>  
               <button id="btnPublicidad"> Publicidad</button>
        </nav>
        <nav>
               <button id="btnArchivos">Archivos Multimedia</button> 
               <button id="btnListas"> Listas de Reproduccion </button>  
               <button id="btnProgListas"> Programacion de listas</button>
            
        </nav>
    </header>
         
    <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">nombre lista</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </tbody>
</table>
        
    
    </body>
      
</html>
