<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
      <spring:url value="/resources/js/jquery.js" var="jquery" />
      <spring:url value="/resources/js/listas.js" var="listasJS" />
      <spring:url value="/resources/js/menu.js" var="menuJS" />
      <spring:url value="/resources/css/listas.css" var="listasCSS" />
      <spring:url value="/resources/css/moveOrden.css" var="moveCSS" />
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

      <link rel="stylesheet" href="${listasCSS}">
      <link rel="stylesheet" href="${moveCSS}">
      <link rel="shortcut icon" href="${logo}">
      <link rel="shortcut icon" href="${homeIMG}">
      <link rel="stylesheet" href="${btCSS}">
      <link rel="stylesheet" href="${alertifyCSS}">
      <link rel="stylesheet" href="${spinnerJS}">
      <link rel="stylesheet" href="${animateCSS}">
      <link rel="stylesheet" href="${menuCSS}">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Listas de Reproducción</title>
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
        <h2 class="text-center pt-5">Listas de Reproducción Existentes</h2>
        <div id="" class="">
          <div class="form-check">
            <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
            <label class="form-check-label ml-4" for="cbGen">
              Seleccionar todos
            </label>
          </div>
          <div class="d-flex justify-content-end">
            <button id="eliminarListas" type="button" name="button" class="btn btn-danger collapse" style="cursor:pointer;" ><i class="fas fa-ban"></i> Eliminar</button>
            <button type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalNuevaLista"><i class="fas fa-plus"></i> Nueva Lista</button>
          </div>
        </div>

        <table class="table table-hover table-bordered mt-2">
          <thead class="">
            <tr>
              <th scope="col" class="text-center"> </th>
              <th scope="col" class="text-center">ID</th>
              <th scope="col" class="text-center">Nombre Lista</th>
              <th scope="col" class="text-center">Descripcion</th>
              <th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${List}" var="dato">
              <c:set var="ultimoID" value="${dato.id}"></c:set>
              <tr>
                <td class="text-center"><input id="${dato.id}" type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                <td class="text-center">${dato.id}</td>
                <td class="text-center">${dato.nombre}</td>
                <td class="text-center">${dato.descripcion}</td>
                <td class="text-center">
                  <a id="${dato.id}" name="${dato.nombre}"  class="ico-program mr-1">
                    <i class="fas fa-list-ul icono"></i>
                  </a>
                  <a id="${dato.id}" name="${dato.nombre}" value="${dato.nombre}-${dato.descripcion}" class="ico-editList" data-toggle="modal" data-target="#modalEditarLista">
                    <i class="fas fa-edit icono"></i>
                  </a>
                  <a id="${dato.id}" name="${dato.nombre}"  class="ico-delList">
                    <i class="fas fa-trash-alt icono"></i>
                  </a>

                </td>
              </tr>
            </c:forEach>

          </tbody>
        </table>
      </div>

      <!-- MODAL EDITAR LISTA DE REPRODUCCI�N-->
      <div class="modal fade" id="modalEditarLista" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalList"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="EditList">
                <div id="modal-bodyList" class="modal-body">
                </div>
                <div class="modal-footer">
                  <button id="updateList" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL EDITAR LISTA DE REPRODUCCI�N -->

      <!-- MODAL BORRAR LISTA DE REPRODUCCI�N-->
      <div class="modal fade" id="modalBorrarLista" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalDelList"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
                <div id="modal-bodyDelList" class="modal-body">
                </div>
                <div class="modal-footer">
                  <form id="DelList">
                    <a id="borrarLista" class="btn btn-warning ml-2"><i class="fas fa-trash-alt"></i> Aceptar</a>
                  </form>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL LISTA DE REPRODUCCI�N -->

      <!-- MODAL NUEVA LISTA DE REPRODUCCI�N -->
      <div class="modal fade" id="modalNuevaLista" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModal"><h5 class="modal-title" id="titleName">Nueva lista de reproducción</h5></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="NewList">
                <div id="modal-body" class="modal-body">
                  <div id="bodyNuevaLista">
                       <div class="col-sm-12 row d-flex justify-content-center align-items-center mt-3">
                          <label for="nombreList" class="col-sm-2 form-control-label mr-2">Nombre:</label>
                          <input class="form-control col-sm-8" id="nombreList" placeholder="Nombre de la lista de reproducci�n" type="text" name="nombreList" required="required">
                       </div>
                       <div class="col-sm-12 row d-flex justify-content-center align-items-center mt-3">
                          <label for="descripcion" class="col-sm-3 form-control-label">Descripción:</label>
                          <input class="form-control col-sm-8" id="descripcion" placeholder="Una peque�a descripci�n" type="text" name="descripcion" required="required">
                       </div>'
                   </div>
                </div>
                <div class="modal-footer">
                  <button id="nuevaLista" type"button" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCI�N -->

      <!-- MODAL NUEVA LISTA DE REPRODUCCI�N -->
      <div class="modal fade" id="modalAgregarArchivos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalNewsFiles"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <!--<form id="NewsFiles">-->
                <div id="modal-bodyNewsFiles" class="modal-body">
                  <div class="form-check">
                    <input class="form-check-input ml-4" type="checkbox" value="" id="cbGenNewFiles" style="cursor:pointer;">
                    <label class="form-check-label ml-4" for="cbGen">
                      Seleccionar todos
                    </label>
                  </div>
                  <table class="table table-hover mt-2">
                    <thead class="">
                      <tr>
                        <th scope="col" class="text-center"> </th>
                        <th scope="col" class="text-center">Nombre archivo</th>
                        <th scope="col" class="text-center">Tipo</th>
                        <th scope="col" class="text-center">Duración (s)</th>
                      </tr>
                    </thead>
                    <tbody>

                      <c:forEach items="${File}" var="dato">
                        <tr>
                          <td class="text-center"><input type="checkbox" class="mt-1 cbNewArc" name="cbNewArc" value="${dato.id}" style="cursor:pointer;"></td>
                          <td class="text-center">${dato.nombre}</td>
                          <td class="text-center">${dato.tipo}</td>
                          <td class="text-center">${dato.duracion}</td>
                        </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                  <input id="ultimoID" type="hidden" name="" value="${ultimoID+1}">
                </div>
                <div class="modal-footer">
                  <button id="nuevosArchivos" type"button" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              <!--</form>-->
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCI�N -->

      <!-- MODAL NUEVA LISTA DE REPRODUCCI�N -->
      <div class="modal fade" id="modalEditarArchivos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalEditFiles"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <!--<form id="NewsFiles">-->
                <div id="modal-bodyNewsFiles" class="modal-body">
                  <div class="d-flex justify-content-end mt-2">
                        <button id="btnEliminar" type="button" name="button" class="btn btn-danger" style="cursor:pointer;" ><i class="fas fa-ban"></i> Eliminar</button>
                        <button id="btnAddFiles" type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalAgregarArchivoLista"><i class="fas fa-plus"></i> Agregar</button>
                    </div>

                    <div id="" class="row">
                        <div class="form-check">
                            <input class="form-check-input ml-4" type="checkbox" value="" id="cbGenOrden" style="cursor:pointer;">
                            <label class="form-check-label ml-4" for="cbGenOrden">
                            Seleccionar todos
                            </label>
                        </div>
                        <div class="ml-5 mb-2 row">
                            <div id="up" class=""><span class="fas fa-chevron-up circle"></span></div>
                            <div id="down" class=""><span class="fas fa-chevron-down circle ml-2"></span></div>
                        </div>
                    </div>

            	  	<table class="table table-hover table-bordered mt-2" id="tableFiles">
                        <thead class="">

                            <tr>
                                <th scope="col" class="text-center "> </th>
                                <th scope="col" class="text-center">Posición</th>
                                <th scope="col" class="text-center">Nombre de Archivo</th>
                                <th scope="col" class="text-center">Tipo</th>
                                <th scope="col" class="text-center">Duración</th>
                                <th scope="col" class="text-center">Acciones</th>
                            </tr>

                        </thead>
                        <tbody id="rows">

                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                  <button id="btnEditFiles" type"button" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              <!--</form>-->
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCI�N -->

      <!-- MODAL NUEVA LISTA DE REPRODUCCI�N -->
      <div class="modal fade" id="modalNoResultados" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalEditFiles"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <!--<form id="NewsFiles">-->
                <div id="modal-bodyNewsFiles" class="modal-body">
                  <div id="exTitle" class="text-center">
                    <h1>Aún no se han agregado archivos a la lista</h1>
                  </div>
                </div>
                <div class="modal-footer">
                  <button id="btnAddFiles2" type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalAgregarArchivoLista"><i class="fas fa-plus"></i> Agregar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                </div>
              <!--</form>-->
          </div>
        </div>
      </div>

      <!-- MODAL NUEVA LISTA DE REPRODUCCI�N -->
      <div class="modal fade" id="modalAgregarArchivoLista" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalEditFiles">Selecciona los nuevos archivos para la lista</div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <!--<form id="NewsFiles">-->
                <div id="modal-bodyNewsFiles" class="modal-body">
                  <div id="modal-bodyNewsFiles" class="modal-body">
                    <div class="form-check">
                      <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                      <label class="form-check-label ml-4" for="cbGen">
                        Seleccionar todos
                      </label>
                    </div>
                    <table class="table table-hover mt-2">
                      <thead class="">
                        <tr>
                          <th scope="col" class="text-center"> </th>
                          <th scope="col" class="text-center">Nombre archivo</th>
                          <th scope="col" class="text-center">Tipo</th>
                          <th scope="col" class="text-center">Duración (s)</th>
                        </tr>
                      </thead>
                      <tbody id="rows2">


                      </tbody>
                    </table>
                    <input id="idLista_archivo" type="hidden" name="" value="">

                </div>
                <div class="modal-footer">
                  <button id="btnNewFiles" type"button" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              <!--</form>-->
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCI�N -->

      <!-- MODAL NUEVA LISTA DE REPRODUCCI�N -->
      <div class="modal fade" id="modalBorrarArchivoLista" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalEditFiles">¿Está seguro que desea borrar los archivos seleccionados?</div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>

                <div id="modal-bodyNewsFiles" class="modal-body">

                </div>
                <div class="modal-footer">
                  <button id="btnDeleteAllFiles" type"button" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>

          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCI�N -->

      <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
      <script src="${jquery}"></script>
      <script src="${btJS}"></script>
      <script src="${alertifyJS}"></script>
      <script src="${spinnerJS}"></script>
      <script src="${listasJS}"></script>
      <script src="${menuJS}"></script>
      <script src="${AJAX}"></script>
    </body>
</html>
