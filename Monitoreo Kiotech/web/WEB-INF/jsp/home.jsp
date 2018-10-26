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
        <spring:url value="/resources/css/menuKiosko.css" var="mainuCSS" />
        <spring:url value="/resources/css/menuKiosko.js" var="mainuJS" />
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
        <link rel="stylesheet" href="${mainuCSS}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>


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

      <h1 class="text-center mt-2">Monitoreo de Kioscos</h1>

      <div class="container mt-4">
        <div class="row">
          <div class="col-md-2">
            <hr>
            <h5 class="bg-dark text-center">Kioskos</h5>
            <hr>
<!--
              <div class="contenedor-mainu">
            		<ul class="mainu">
            			<li><a href="#"><i class="icono izquierda fa fa-star"></i>Productos<i class="icono derecha fa fa-chevron-down"></i></a>
            				<ul>
            					<li><a href="http://www.falconmasters.com">Item 1</a></li>
            					<li><a href="https://www.google.com">Item 2</a></li>
            					<li><a href="http://www.tutorialdephp.com">Item 3</a></li>
            					<li><a href="http://www.falconmasters.com">Item 4</a></li>
            				</ul>
            			</li>
            			<li><a href="#"><i class="icono izquierda fa fa-share-alt"></i>Redes Sociales<i class="icono derecha fa fa-chevron-down"></i></a>
            				<ul>
            					<li><a href="#">Item 1</a></li>
            					<li><a href="#">Item 2</a></li>
            					<li><a href="#">Item 3</a></li>
            					<li><a href="#">Item 4</a></li>
            				</ul>
            			</li>
            			<li><a href="#"><i class="icono izquierda fa fa-envelope"></i>Contactanos</a></li>
            		</ul>
            	</div>-->
          </div>

          <div id="vistaAgencia" class="col-md-10">
            <div class="">
              <hr>
              <h4 class="text-center">Agencia Plaza Zentralia</h4>
              <hr>
            </div>
            <div class="bg-warning rounded">
              <div class="container mt-2">
                <div class="row">
                  <div class="col-md-1">
                    <i class="icono izquierda fas fa-exclamation-triangle mt-2"></i>
                  </div>
                  <div class="col-md-10 my-1">
                    <h4>2 Kioskos presentan alertas</h4>
                  </div>
                  <div class="col-md-1">
                    <i class="icono izquierda fas fa-share-square mt-2"></i>
                  </div>
                </div>
              </div>
            </div>
            <div class="container mt-2">
              <div class="row">
                <div class="col-md-4">
                  <!--Kioskos en Servicio-->
                  <div class="container">
                    <hr>
                    <div class="row">
                      <div class="col-md-10">
                        <h5 class="text-success text-center">10</h5>
                        <h5 class="text-success text-center">Kioskos en Servicio</h5>
                      </div>
                      <div class="col-md-2">
                        <!--Gráfica-->
                        AQUI VA UNA GRAFICA DE PASTEL
                      </div>
                    </div>
                    <hr>
                  </div>
                </div>
                <div class="col-md-4">
                  <!--Kioskos en Mantenimiento-->
                  <div class="container">
                    <hr>
                    <div class="row">
                      <div class="col-md-10">
                        <h5 class="text-warning text-center">2</h5>
                        <h5 class="text-warning text-center">Kioskos en Mantenimiento</h5>
                      </div>
                      <div class="col-md-2">
                        <!--Gráfica-->
                        AQUI VA UNA GRAFICA DE PASTEL
                      </div>
                    </div>
                    <hr>
                  </div>
                </div>
                <div class="col-md-4">
                  <!--Kiosko Desconectado-->
                  <div class="container">
                    <hr>
                    <div class="row">
                      <div class="col-md-10">
                        <h5 class="text-danger text-center">3</h5>
                        <h5 class="text-danger text-center">Kioskos Desconectados</h5>
                      </div>
                      <div class="col-md-2">
                        <!--Gráfica-->
                        AQUI VA UNA GRAFICA DE PASTEL
                      </div>
                    </div>
                    <hr>
                  </div>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-md-6">
                  <!--Alertas en el mes-->
                  <hr>
                  <h4 class="text-center">Alertas en el mes</h4>
                  <!--

                    AQUI VA UNA GRÁFICA


                  -->
                  AQUI VA UNA GRAFICA DE BARRAS
                  <hr>
                </div>
                <div class="col-md-6">
                  <!--Disponibilidad de kioskos en el mes-->
                  <hr>
                  <h4 class="text-center">Disponibilidad de kioskos en el mes</h4>
                  <!--

                    AQUI VA UNA GRÁFICA


                  -->
                  AQUI VA UNA GRAFICA LÍNEAL
                  <hr>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer>
        <div class="container mt-4">
          <a><a class="font-weight-bold">Servidor central (192.168.1.1):</a><a class="font-weight-bold text-success ml-5">Conectado <i class="fas fa-desktop"></i></a></a>
        </div>
      </footer>

    <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
    <script src="${jquery}"></script>
    <script src="${btJS}"></script>
    <script src="${alertifyJS}"></script>
    <script src="${spinnerJS}"></script>
    <script src="${homeJS}"></script>
    <script src="${menuJS}"></script>
    <script src="${AJAX}"></script>
    <script src="${mainuJS}"></script>

    </body>

</html>
