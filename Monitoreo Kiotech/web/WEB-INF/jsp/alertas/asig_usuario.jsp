<%-- 
    Document   : asig_usuario
    Created on : 15/10/2018, 06:25:52 PM
    Author     : Jesús Mendoza
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
     
        <spring:url value="/resources/js/jquery.js" var="jquery" /> 
        
      <spring:url value="/resources/js/archivos.js" var="archivosJS" />
      <spring:url value="/resources/js/menu.js" var="menuJS" />
      <spring:url value="/resources/css/archivos.css" var="archivosCSS" />
      <spring:url value="/resources/images/logo.png" var="logo" />
      <spring:url value="/resources/images/home.png" var="homeIMG" />
      <spring:url value="/resources/images/form1.png" var="userIMG" />
      <spring:url value="/resources/css/bootstrap/bootstrap.css" var="btCSS" />
      <spring:url value="/resources/js/bootstrap/bootstrap.js" var="btJS" />
      <spring:url value="/resources/js/homeAJAX.js" var="AJAX" />
      <spring:url value="/resources/alertifyjs/css/alertify.css" var="alertifyCSS" />
      <spring:url value="/resources/css/spinner.css" var="spinnerCSS" />
      <spring:url value="/resources/css/animate.min.css" var="animeteCSS" />
      <spring:url value="/resources/css/menu.css" var="menuCSS" />
      <spring:url value="/resources/js/spinner.js" var="spinnerJS" />
      <spring:url value="/resources/alertifyjs/alertify.js" var="alertifyJS" />

      <link rel="stylesheet" href="${archivosCSS}">
      <link rel="shortcut icon" href="${logo}">
      <link rel="shortcut icon" href="${homeIMG}">
      <link rel="stylesheet" href="${btCSS}">
      <link rel="stylesheet" href="${alertifyCSS}">
      <link rel="stylesheet" href="${spinnerJS}">
      <link rel="stylesheet" href="${animateCSS}">
      <link rel="stylesheet" href="${menuCSS}">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignacion de Usuarios</title>
    </head>
    <body>
        
        
      <!-- Menú lateral -->
      <div id="sidebar" class="sidebar collapse ">
        <h4>Menú <span id="cerrarMenu" class=""><i class="fas fa-chevron-left"></i></span></h4>
        <ul class="menu">
          <li><a id="menuMonitoreo" class="" href="<c:url value='home.htm' />"><i class="icono izquierda fas fa-desktop"></i> Monitoreo de Kioscos</a></li>
          <li><a id="menuAlertas" class="" href="#"><i class="icono izquierda fas fa-exclamation-circle"></i> Alertas <i class="icono derecha fas fa-chevron-down"></i></a>
            <ul>

                <li><a id="historial" class="" href="<c:url value='historial.htm' />"><i class="icono izquierda fa fa-history"></i> Historial de alertas</a></li>
                <li><a id="configEnvio" class="" href="<c:url value='medio_envio.htm' />"><i class="icono izquierda fas fa-truck"></i> Medio de envío</a></li>
                <li><a id="configEvento" class="" href="<c:url value='eventos.htm' />"><i class="icono izquierda fas fa-calendar-alt"></i> Config. de eventos</a></li>
                <li><a id="usuarios" class="" href="<c:url value='asignar_usuario.htm' />"><i class="icono izquierda fas fa-user-plus"></i> Asignación de usuarios</a></li>

            </ul>
          </li>
          <li><a id="menuPublicidad" class="" href="#"><i class="icono izquierda fas fa-play-circle"></i> Publicidad <i class="icono derecha fas fa-chevron-down"></i> </a>
            <ul>

                <li><a id="archivosMultimedia" class="" href="<c:url value='archivos.htm' />"><i class="icono izquierda fas fa-file-archive"></i> Archivos multimedia</a></li>
                <li><a id="listasReproduccion" class="" href="<c:url value='listas.htm' />"><i class="icono izquierda fas fa-list-ul"></i> Listas de reproduccion</a></li>
                <li><a id="programacionListas" class="" href="<c:url value='programacion.htm' />"><i class="icono izquierda fas fa-tasks"></i> Programación de listas</a></li>

            </ul>
          </li>
          <li><a id="salir" class="" href="<c:url value='archivos.htm' />"><i class=" icono izquierda fas fa-sign-out-alt "></i> Cerrar Sesión</a></li>
        </ul>

        <div class="userCar text-center mt-1">
          <img  src="${userIMG}" height="50px" class="navb" alt="">
          <p>Bienvenido<br>${usuario}</p>
          <p>Agencia: ${agencia}</p>
          <img src="${logo}" width="200" class="navb mt-1" alt="">
        </div>


      </div>
      <div class="contenido">
        <span id="abrirMenu"><i class="fas fa-list-ul"></i></span>
      </div>
      <!-- Menú lateral -->
        
        
        <div class="container">
            <h2 class="text-center pt-5">Asignacion de Usuarios</h2>
        <div id="" class="">
                <div class="form-check">
                  <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                  <label class="form-check-label ml-4" for="cbGen">
                    Seleccionar todos
                  </label>
                </div>
                <div class="d-flex justify-content-end">
                    <button type="button" name="button" class="btn btn-info" style="cursor:pointer;">
                        <i class="fa fa-users"> </i>
                        Asignar Elementos</button>
                </div>
              </div>
                      <table class="table table-hover mt-2">
                <thead class="">
                  <tr>
                    <th scope="col" class="text-center"> </th>
                    <th scope="col" class="text-center">ID</th>
                    <th scope="col" class="text-center">Nombre Usuario</th>
                    <th scope="col" class="text-center">Agencia</th>
                    <th scope="col" class="text-center">Envio de Email</th>
                    <th scope="col" class="text-center">Envio de SMS</th>
                    <th scope="col" class="text-center">Acciones</th>
                  </tr>
                </thead>
                      </table>
    </div>
        
        <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
      <script src="${jquery}"></script>
      <script src="${btJS}"></script>
      <script src="${alertifyJS}"></script>
      <script src="${spinnerJS}"></script>
      <script src="${programacionJS}"></script>
      <script src="${menuJS}"></script>
      <script src="${AJAX}"></script>
    </body>
</html>
