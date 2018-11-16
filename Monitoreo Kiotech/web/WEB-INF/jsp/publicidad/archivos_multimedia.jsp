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
      <title>Archivos Multimedia</title>
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
        <h2 class="text-center pt-5">Archivos multimedia existentes en el servidor</h2>
        <div id="" class="">
          <div class="form-check">
            <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
            <label class="form-check-label ml-4" for="cbGen">
              Seleccionar todos
            </label>
          </div>
          <div class="d-flex justify-content-end">
            <button id="eliminarArchivos" type="button" name="button" class="btn btn-danger collapse" style="cursor:pointer;"><i class="fas fa-ban"></i> Eliminar</button>
            <button type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalNuevoArchivo"><i class="fas fa-cloud-upload-alt"></i> Subir nuevo archivo</button>
          </div>
        </div>

        <table class="table table-hover table-bordered mt-2">
          <thead class="">
            <tr>
              <th scope="col" class="text-center"> </th>
              <th scope="col" class="text-center">ID</th>
              <th scope="col" class="text-center">Nombre archivo</th>
              <th scope="col" class="text-center">Tipo</th>
              <th scope="col" class="text-center">Duracion (s)</th>
              <th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${File}" var="dato">

              <tr>
                <td class="text-center"><input id="${dato.id}" type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                <td class="text-center">${dato.id}</td>
                <td class="text-center">${dato.nombre}</td>
                <td class="text-center">${dato.tipo}</td>
                <td class="text-center">${dato.duracion}</td>
                <td class="text-center">
                  <a id="${dato.id}" name="${dato.nombre}" value="${dato.nombre}-${dato.tipo}-${dato.duracion}" class="ico-edit" data-toggle="modal" data-target="#modalEditarArchivo">
                    <i class="fas fa-edit icono"></i>
                  </a>
                  <a id="${dato.id}" name="${dato.nombre}"  class="ico-del">
                    <i class="fas fa-trash-alt icono"></i>
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>


      <!-- MODAL EDITAR ARCHIVO-->
      <div class="modal fade" id="modalEditarArchivo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModal"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="EditFile">
                <div id="modal-body" class="modal-body">
                </div>
                <div class="modal-footer">
                  <button id="updateArchivo" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL EDITAR ARCHIVO -->

      <!-- MODAL NUEVO ARCHIVO-->
      <div class="modal fade" id="modalNuevoArchivo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModal"><h5 class="modal-title" id="titleName">Nuevo Archivo</h5></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="NewFile" name="NewFile" enctype="multipart/form-data" method="POST">
                <div id="modal-body" class="modal-body">
                  <div id="bodyEdit">
                       <input id="file" type="file" name="file">
                         <div class="col-sm-12 row d-flex justify-content-start align-items-center mt-3 mb-2">
                            <label for="duracion" class="col-sm-3 form-control-label">Duraci�n:</label>
                            <input class="form-control col-sm-4" id="duracion" placeholder="Segundos" type="number" name="duracion" required="required" value="60" min="1">
                         </div>
                   </div>
                </div>
                <div class="modal-footer">
                  <button id="nuevoArchivo" type"submit" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVO ARCHIVO -->

      <!-- MODAL BORRAR ARCHIVO-->
      <div class="modal fade" id="modalBorrarArchivo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalDel"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
                <div id="modal-bodyDel" class="modal-body">
                </div>
                <div class="modal-footer">
                  <form id="DelFile">
                    <a id="borrarArchivo" class="btn btn-warning ml-2"><i class="fas fa-trash-alt"></i> Aceptar</a>
                  </form>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL BORRAR ARCHIVO -->

      <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
      <script src="${jquery}"></script>
      <script src="${btJS}"></script>
      <script src="${alertifyJS}"></script>
      <script src="${spinnerJS}"></script>
      <script src="${archivosJS}"></script>
      <script src="${menuJS}"></script>
      <script src="${AJAX}"></script>
    </body>
</html>
