<%--
    Document   : historial_alertas
    Created on : 15/10/2018, 06:24:16 PM
    Author     : Jesús Mendoza
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <spring:url value="/resources/js/jquery.js" var="jquery" />

        <spring:url value="/resources/js/home.js" var="homeJS" />
        <spring:url value="/resources/js/menu.js" var="menuJS" />
        <spring:url value="/resources/css/home.css" var="homeCSS" />
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

        <link rel="stylesheet" href="${homeCSS}">
        <link rel="shortcut icon" href="${logo}">
        <link rel="shortcut icon" href="${homeIMG}">
        <link rel="stylesheet" href="${btCSS}">
        <link rel="stylesheet" href="${alertifyCSS}">
        <link rel="stylesheet" href="${spinnerJS}">
        <link rel="stylesheet" href="${animateCSS}">
        <link rel="stylesheet" href="${menuCSS}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial de Alertas</title>
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
          <h2 class="text-center pt-5">Historial de Alertas</h2>

         <!--<button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-controls="collapseOne" style="cursor:pointer;">
                      <i class="fa fa-info"> </i>
                      Opciones Avanzadas
                    </button>-->

          <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne" aria-controls="collapseOne" style="cursor:pointer;">
           <i class="fa fa-info"> </i>
           Búsqueda Avanzada
          </button>
          <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
            <hr>
              <!--Menú desplegable al presionar búsqueda Avanzada-->
            <div class="container">
              <div class="card-body">
                 <form class="form-inline" action="">
                     <div class="row">
                       <!--Columnas de llenado de información-->
                       <div class="col-md-11">
                          <div class="form-group">
                              <label for="text" class="mr-1">Rango de Fechas desde el dia:</label>
                              <!--<input type="date" class="form-control" id="calendario">
                              <button type="button" name="button" class="btn btn-outline-light">
                                <i class="fa fa-calendar" aria-hidden="true"></i>
                              </button>-->
                              <div class="input-group-sm mr-2">
                                <div class="input-group-addon">
                                  <span class="input-group-text" id="basic-addon1"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                </div>
                                <input type="date" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                              </div>
                              <label for="text" class="mr-1">a las:</label>
                              <input type="time" class="form-control mr-1" id="horaInicial">
                              <label for="text" class="mr-1">hrs. hasta el dia:</label>
                              <div class="input-group-sm mr-2">
                                <div class="input-group-addon">
                                  <span class="input-group-text" id="basic-addon2"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                </div>
                                <input type="date" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                              </div>
                              <label for="text" class="mr-1">a las:</label>
                              <input type="time" class="form-control mr-3" id="horaFinal">
                          </div>
                          <!--Segunda linea de llenado de información-->
                          <div class="form-group mt-3">
                            <label for="text" class="mr-1">Tipo de alerta:</label>
                            <select class="custom-select mr-5" id="inputGroupSelect01">
                              <option selected>-------------</option>
                              <option value="1">Todas</option>
                              <option value="2">Desconexión o falla en dispositivo</option>
                            </select>
                            <label for="text" class="mr-1">Usuario:</label>
                            <select class="custom-select mr-5" id="inputGroupSelect01">
                              <option selected>----------</option>
                              <option value="1">Todos</option>
                              <!--Aquí debe de buscar a todos los usuarios-->
                              <option value="2">${usuario}</option>
                            </select>
                            <label for="text" class="mr-1">Kiosco:</label>
                            <select class="custom-select mr-5" id="inputGroupSelect01">
                              <option selected>----------</option>
                              <option value="1">Todos</option>
                              <!--Aquí debe buscar todos los kioscos activos-->
                              <option value="1">Kiosco 1</option>
                            </select>
                          </div>
                       </div>
                       <!--Columna para el botón-->
                       <div class="col-md-1">
                         <button type="button" class="btn btn-info mt-4">Buscar <i class="fa fa-search"> </i></button>
                       </div>
                     </div>
                 </form>
               </div>
             </div>
             <hr>
           </div>


              <table class="table table-hover mt-2">
                <thead class="">
                  <tr>
                    <th scope="col" class="text-center"> </th>
                    <th scope="col" class="text-center">ID</th>
                    <th scope="col" class="text-center">Fecha y Hora</th>
                    <th scope="col" class="text-center">Tipo de Alerta</th>
                    <th scope="col" class="text-center">Mensaje</th>
                    <th scope="col" class="text-center">Kiosko</th>
                    <th scope="col" class="text-center">Acciones</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${File}" var="dato">

                  </c:forEach>
                </tbody>
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
