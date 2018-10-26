<%--
    Document   : configuracion_eventos
    Created on : 15/10/2018, 06:25:02 PM
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
      <title>Configuracion de Eventos</title>
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
      
      	  <div class="userCar text-center mt-5">
      	    <img  src="${userIMG}" height="50px" class="navb" alt="">
      	    <p class="mt-3">Bienvenido<br>${usuario}</p>
      	    <p>Agencia: ${agencia}</p>
      	  </div>
      
      
      	</div>
      	<div class="contenido">
      	  <span id="abrirMenu"><i class="fas fa-list-ul"></i></span>
      	</div>
      	<!-- Menú lateral -->

      <div class="container">
        <h2 class="text-center pt-5">Configuracion de Eventos</h2>
        <table class="table table-hover mt-2">
          <thead class="">
            <tr>
              <th scope="col" class="text-center">ID</th>
              <th scope="col" class="text-center">Evento (Tipo de Alerta)</th>
              <th scope="col" class="text-center">Mensaje</th>
              <th scope="col" class="text-center">Activo</th>
              <th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${evento}" var="dato">
              <c:set var="activo" value="${dato.activo}"></c:set>
              <tr>
                <td class="text-center">${dato.id}</td>
                <td class="text-center">${dato.nombre}</td>
                <td class="text-center">${dato.mensaje}</td>
                <c:if test="${activo == true}">
                  <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" checked></td>
                </c:if>
                <c:if test="${activo == false}">
                  <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled"></td>
                </c:if>
                <td class="text-center">
                  <a id="${dato.id}" name="${dato.nombre}" value="${dato.nombre}-${dato.mensaje}-${dato.activo}" class="ico-conf" data-toggle="modal" data-target="#modalMinFolios">
                    Configurar <i class="fas fa-cog icono"></i>
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>

      <!-- MODAL BORRAR LISTA DE REPRODUCCI�N-->
      <div class="modal fade" id="modalMinFolios" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalMinFolios"> <h2 class="text-center">Configuración de Evento 12</h2></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
                <div id="modal-bodyMinFolios" class="modal-body row mt-5 mb-5 d-flex justify-content-center">
                  <label for="folios" class="form-control-label col-sm-6">Cantidad Mínima de Folios: </label>
                  <input id="folios" class="form-control col-sm-3" type="number" class="form-input ml-2" name="" value="10" min="5">
                </div>
                <div class="modal-footer">
                  <form id="DelMinFolios">
                    <a id="btnMinFolios" class="btn btn-warning ml-2"><i class="fas fa-trash-alt"></i> Aceptar</a>
                  </form>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL LISTA DE REPRODUCCI�N -->

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
