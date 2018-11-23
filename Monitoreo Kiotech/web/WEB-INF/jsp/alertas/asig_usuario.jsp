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

        <spring:url value="/resources/js/asig_usuario.js" var="usuarioJS" />
        <spring:url value="/resources/js/menu.js" var="menuJS" />
        <spring:url value="/resources/js/archivos.js" var="archivosJS" />
        <spring:url value="/resources/css/archivos.css" var="archivosCSS" />
        <spring:url value="/resources/images/logo.png" var="logo" />
        <spring:url value="/resources/images/home.png" var="homeIMG" />
        <spring:url value="/resources/images/form1.png" var="userIMG" />
        <spring:url value="/resources/css/bootstrap/bootstrap.css" var="btCSS" />
        <spring:url value="/resources/js/bootstrap/bootstrap.js" var="btJS" />
        <spring:url value="/resources/js/homeAJAX.js" var="AJAX" />
        <spring:url value="/resources/alertifyjs/css/alertify.css" var="alertifyCSS" />
        <spring:url value="/resources/css/animate.min.css" var="animeteCSS" />
        <spring:url value="/resources/css/menu.css" var="menuCSS" />
        <spring:url value="/resources/alertifyjs/alertify.js" var="alertifyJS" />

        <link rel="stylesheet" href="${archivosCSS}">
        <link rel="shortcut icon" href="${logo}">
        <link rel="shortcut icon" href="${homeIMG}">
        <link rel="stylesheet" href="${btCSS}">
        <link rel="stylesheet" href="${alertifyCSS}">
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
                <li><a id="salir" class="" href="<c:url value='cerrar_sesion.htm' />"><i class=" icono izquierda fas fa-sign-out-alt "></i> Cerrar Sesión</a></li>
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
            <h2 class="text-center pt-5">Asignacion de Usuarios</h2>
            <div id="" class="">
                <div class="form-check">
                    <input class="form-check-input ml-4" type="checkbox" value="" id="cbUsuarios" style="cursor:pointer;">
                    <label class="form-check-label ml-4" for="cbUsuarios">
                        Seleccionar todos
                    </label>
                </div>
                <div class="d-flex justify-content-end">
                    <button id="btnUsuariosEventos" type="button" name="button" class="btn btn-info collapse" style="cursor:pointer;" data-toggle="modal" data-target="#asignarAlertaUsuario">
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
                        <th scope="col" class="text-center">Correo</th>
                        <th scope="col" class="text-center">Celular</th>
                        <th scope="col" class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuarios}" var="dato">
                        <tr>
                            <td class="text-center"><input id="${dato.id}" type="checkbox" class="mt-1 cbUsuario" name="${dato.nombre}"></td>
                            <td class="text-center">${dato.id}</td>
                            <td class="text-center">${dato.nombre}</td>
                            <td class="text-center">${dato.agencia}</td>
                            <td class="text-center">${dato.correo}</td>
                            <td class="text-center">${dato.celular}</td>

                            <td class="text-center">
                                <a id="${dato.id}" name="${dato.nombre}" value="" class="ico-alertas">
                                    <i class="fas fa-desktop icono"></i>
                                </a>
                                <a id="${dato.id}" name="${dato.nombre}" value="" class="ico-kiosco">
                                    <i class="fas fa-exclamation-triangle icono"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- MODAL KIOSCOS ASIGNADOS AL USUARIO-->
        <div class="modal fade" id="kioscoUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <div id="tituloModal">Alertas asignadas a </div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                        <div id="modal-body" class="modal-body">
                            <div class="form-check right float-right">
                                <input class="form-check-input ml-4" type="checkbox" value="" id="cbEv" style="cursor:pointer;">
                                <label class="form-check-label ml-4" for="cbEv">
                                    Seleccionar todos
                                </label>
                            </div>
                            <table class="table table-hover mt-2">
                                <thead class="">
                                    <tr>
                                        <th scope="col" class="text-center">ID</th>
                                        <th scope="col" class="text-center">Evento (tipo de alerta)</th>
                                        <th scope="col" class="text-center">Activo</th>
                                    </tr>
                                </thead>
                                <tbody id="rows2">

                                </tbody>
                            </table>
                        </div>
                        <input type="hidden" id="usuarioHidden2" name="" value="">
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button id="btnEventos" class="btn btn-success ml-2">Guardar</button>
                        </div>

                </div>
            </div>
        </div>
        <!-- FIN DEL MODAL KISCOS ASIGNADOS AL USUARIO -->

        <!-- MODAL ALERTAS ASIGNADAS AL USUARIO-->
        <div class="modal fade" id="alertasUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <div id="tituModal">Kioscos asignados a </div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                        <div id="modal-cuerpo" class="modal-body">
                            <div class="form-check right float-right">
                                <input class="form-check-input ml-4" type="checkbox" value="" id="cbAlerta" style="cursor:pointer;">
                                <label class="form-check-label ml-4" for="cbAlerta">
                                    Seleccionar todos
                                </label>
                            </div>
                            <table class="table table-hover mt-2">
                                <thead class="">
                                    <tr>
                                        <th scope="col" class="text-center">ID</th>
                                        <th scope="col" class="text-center">Nombre kiosco</th>
                                        <th scope="col" class="text-center">Recibir alertas de este kiosco</th>
                                    </tr>
                                </thead>
                                <tbody id="rows">

                                </tbody>
                                <input type="hidden" id="usuarioHidden" name="" value="">

                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button id="guardarArchivo" class="btn btn-success ml-2">Guardar</button>
                        </div>

                </div>
            </div>
        </div>
        <!-- FIN DEL MODAL ALERTAS ASIGNADAS AL USUARIO -->

        <!-- MODAL KIOSCOS ASIGNAR ALERTAS AL USUARIO-->
        <div class="modal fade bd-example-modal-lg" id="asignarAlertaUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">

                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 id="tiModal">Asignar alertas a usuarios</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                            <div id="modal-body" class="modal-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="mt-2">
                                            <table class="table table-hover mt-2">
                                                <thead class="">
                                                    <tr>
                                                        <th class="text-center"><input type="checkbox" class="mt-1" id="cbUser" name="cbUser"></th>
                                                        <th id="selUs" scope="col" class="text-center"> </th>
                                                    </tr>
                                                </thead>
                                                <tbody id=usBody>

                                                </tbody>
                                            </table>
                                        </div>
                                        <hr>
                                        <p class="mt-5">Enviar alertas a través de</p>
                                        <hr>
                                        <div class="form-check right float-center mt-2">
                                            <input class="form-check-input ml-4" type="checkbox" value="" id="cbCorreo" style="cursor:pointer;">
                                            <label class="form-check-label ml-4" for="cbCorreo">
                                                Correo electrónico
                                            </label>
                                        </div>
                                        <div class="form-check right float-center mt-2">
                                            <input class="form-check-input ml-4" type="checkbox" value="" id="cbMensaje" style="cursor:pointer;">
                                            <label class="form-check-label ml-4" for="cbMensaje">
                                                Mensajes de texto
                                            </label>
                                        </div>
                                        <hr>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-check right float-right">
                                            <input class="form-check-input ml-4" type="checkbox" value="" id="cbEventos" style="cursor:pointer;">
                                            <label class="form-check-label ml-4" for="cbEventos">
                                                Seleccionar todos
                                            </label>
                                        </div>
                                        <table class="table table-hover mt-2">
                                            <thead class="">
                                                <tr>
                                                    <th scope="col" class="text-center">ID</th>
                                                    <th scope="col" class="text-center">Evento (tipo de alerta)</th>
                                                    <th scope="col" class="text-center">Activo</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${evento}" var="evento">
                                                    <tr>
                                                        <td class="text-center">${evento.id}</td>
                                                        <td class="text-center">${evento.nombre}</td>
                                                        <c:if test="${evento.activo == true}">
                                                            <td class="text-center"><input id="${evento.id}" type="checkbox" class="mt-1 cbEvento" name="cbEvento" checked></td>
                                                        </c:if>
                                                        <c:if test="${evento.activo == false}">
                                                            <td class="text-center"><input id="${evento.id}" type="checkbox" class="mt-1 cbEvento" name="cbEvento"></td>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btnMultiEventos" class="btn btn-success ml-2">Guardar</button>
                            </div>

                    </div>

            </div>
        </div>
        <!-- FIN DEL MODAL ASIGNAR ALERTAS AL USUARIO -->

        <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
        <script src="${jquery}"></script>
        <script src="${btJS}"></script>
        <script src="${alertifyJS}"></script>
        <script src="${menuJS}"></script>
        <script src="${AJAX}"></script>
        <script src="${usuarioJS}"></script>
    </body>
</html>
