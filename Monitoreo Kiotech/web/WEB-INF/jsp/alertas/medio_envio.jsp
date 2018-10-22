<%--
    Document   : medio_envio
    Created on : 15/10/2018, 06:24:40 PM
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
      <title>Medios de envio</title>
    </head>
    <body>

      <header>
        <div class="container-fluid sinmargin sinpadding">
          <div class="row">
            <!--Primera Columna-->
            <div class="col-4">
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
            </div>

            <!--Segunda Columna-->
            <div class="col-4 float-right mt-3">
              <h2 class="text-center">Medios de Envio</h2>
            </div>

            <!--Tercera Columna-->
            
          </div>
        </div>
      </header>

      <!--Sección del formulario del servidor y SMS-->
      <section>
        <div class="container mt-4">
          <div class="row">
            <div class="col-7">
              <h5>Servidor de Correos</h5> <hr>
              <div class="container">
                <h5 class="mt-3">Configuración</h5><hr>
                <div class="conteiner">
                  <div class="row">
                    <div class="col-md-8">
                      <form class="form-vertical">
                        <div class="form-group">
                          <div class="input-group">
                            <label class="mr-3">Servidor SMTP:</label>
                            <input type="text" class="form-control" placeholder="mail.dominio.com.mx">
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="input-group">
                            <label class="mr-3">Usuario:</label>
                            <input type="email" class="form-control" placeholder="correo@dominio.com.mx">
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="input-group">
                            <label class="mr-3">Contraseña:</label>
                            <input type="password" class="form-control" placeholder="Password">
                          </div>
                        </div>
                      </form>
                    </div>
                    <div class="col-md-4">
                      <div class="form-group">
                        <div class="input-group">
                          <label class="mr-3">Puerto:</label>
                          <input type="number" class="form-control" placeholder="8080">
                        </div>
                      </div>
                      <div class="input-group">
                        <label class="mr-3">Seguridad:</label>
                        <select class="custom-select" id="inputGroupSelect01">
                          <option selected>----</option>
                          <option value="1">TLS</option>
                          <option value="2">SSL</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>
                <hr>
              </div>



              <div class="container">
                <div class="row">
                  <!--Aquí va el Spinner de guardando configuración-->
                  <div class="col-md-9">
                    <p class="text-center">Guardando Configuración</p>
                  </div>
                  <div class="col-md-2">
                    <button type="button" class="btn btn-success">Guardar</button>
                  </div>
                </div>
              </div>

              <br>

              <div class="container">
                <h5 class="mt-2">Probar Configuración</h5><hr>
                <div class="container">
                  <div class="row">
                    <div class="col-md-9">
                      <form class="form-vertical">
                        <div class="form-group">
                          <div class="input-group">
                            <label class="mr-3">Mensaje:</label>
                            <input type="text" class="form-control" placeholder="Aquí va tu mensaje">
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="input-group">
                            <label class="mr-3">Correo:</label>
                            <input type="email" class="form-control" placeholder="correo@dominio.com.mx">
                          </div>
                        </div>
                      </form>
                    </div>
                    <div class="col-md-3">
                      <button class="btn btn-info mt-4" type="button">Enviar Prueba</button>
                    </div>
                  </div>
                </div>
              </div>

              <hr>

              <!--Aquí va el Spinner de carga-->
              <div class="container">
                <p class="text-center">Enviando correo</p>
              </div>

            </div>
            <div class="col-5">
              <h5>Tarjeta SMS</h5> <hr>
              <div class="container">
                <h5>Configuración</h5><hr>
                <div class="conteiner">
                  <div class="row">
                    <div class="col-md-10">
                      <div class="input-group">
                        <label class="mr-3">Puerto:</label>
                        <select class="custom-select" id="inputGroupSelect01">
                          <option selected>----</option>
                          <option value="1">COM1</option>
                          <option value="2">COM2</option>
                        </select>
                      </div>
                    </div>
                    <div class="col-md-2">
                      <button class="btn btn-success" type="button" >Guardar</button>
                    </div>
                  </div>
                </div>
              </div>
              <hr>

                <!--Aquí va el Spinner-->
              <p class="text-center">Guardando Configuración</p>

              <div class="container">
                <h5 class="mt-5">Probar Configuración</h5><hr>
                <div class="form-group">
                  <div class="input-group">
                    <label class="mr-3">Mensaje:</label>
                    <input type="text" class="form-control" placeholder="Aquí va tu mensaje">
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-9">
                    <div class="form-group">
                      <div class="input-group">
                        <label class="mr-3">Celular:</label>
                        <input type="text" class="form-control" placeholder="3122345678">
                      </div>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <button type="button" class="btn btn-info mt-0">Enviar Prueba</button>
                  </div>
                </div>
                <hr>
              </div>

              <!--Aquí va el Spinner de carga-->
              <div class="container">
                <p class="text-center">Enviando correo</p>
              </div>

            </div>
          </div>
        </div>
      </section>



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
