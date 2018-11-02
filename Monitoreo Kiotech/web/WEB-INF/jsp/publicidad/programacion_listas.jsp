<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
      <spring:url value="/resources/js/jquery.js" var="jquery" />
      <spring:url value="/resources/js/programacion.js" var="programacionJS" />
      <spring:url value="/resources/js/menu.js" var="menuJS" />
      <spring:url value="/resources/css/programacion.css" var="programacionCSS" />
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

      <link rel="stylesheet" href="${programacionCSS}">
      <link rel="shortcut icon" href="${logo}">
      <link rel="shortcut icon" href="${homeIMG}">
      <link rel="stylesheet" href="${btCSS}">
      <link rel="stylesheet" href="${alertifyCSS}">
      <link rel="stylesheet" href="${spinnerJS}">
      <link rel="stylesheet" href="${animateCSS}">
      <link rel="stylesheet" href="${menuCSS}">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Programación de listas</title>
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
        <h2 class="text-center pt-5">Programación de Listas de Reproducción en Kioscos</h2>
        <div id="" class="">
          <div class="form-check">
            <input class="form-check-input ml-4" type="checkbox" value="" id="cbGenKiosco" style="cursor:pointer;">
            <label class="form-check-label ml-4" for="cbGen">
              Seleccionar todos
            </label>
          </div>
        </div>

        <div class="row col-12">
          <table class="table-sm table-hover table-bordered mt-2 col-sm-4">
            <thead class="">
              <tr>
                <th scope="col" class="text-center"> </th>
                <th scope="col" class="text-center">ID</th>
                <th scope="col" class="text-center">Kiosco</th>
                <th scope="col" class="text-center">Agencia</th>
              </tr>
            </thead>
            <tbody>
               <c:set var="contador" value="${0}"></c:set>
               <c:forEach items="${kiosco}" var="dato">
                    <c:set var="contador" value="${contador+1}"></c:set>
                      <!--<c:out value="${contador}"></c:out>-->
                    <c:if test = "${contador ==  1}">
                        <form>
                          <tr id="${dato.id}" name="${dato.nombre}" class="select primero" value="${dato.nombre}-${dato.agencia}">
                            <td class="text-center"><input type="checkbox" class="mt-1 cbKio" name="cbKio" value="${dato.id}-${dato.nombre}" style="cursor:pointer;"></td>
                            <td class="text-center">${dato.id}</td>
                            <td class="text-center">${dato.nombre}</td>
                            <td class="text-center">${dato.agencia}</td>
                          </tr>
				        </form>
				    </c:if>
                    <c:if test = "${contador !=  1}">
                        <form>
                          <tr id="${dato.id}" name="${dato.nombre}" class="select" value="${dato.nombre}-${dato.agencia}">
                            <td class="text-center"><input type="checkbox" class="mt-1 cbKio" name="cbKio" value="${dato.id}-${dato.nombre}" style="cursor:pointer;"></td>
                            <td class="text-center">${dato.id}</td>
                            <td class="text-center">${dato.nombre}</td>
                            <td class="text-center">${dato.agencia}</td>
                          </tr>
				        </form>
				    </c:if>
          </c:forEach>
        </tbody>
      </table>

      <div class="collapse" id="MultSection" style="margin-left:50%">
        <h1 class="text-center" id="textMultKio"></h1>
        <a id="btnMultList" class="btn btn-info text-center ml-5"><i class="icono izquierda fas fa-plus-circle"></i> Agregar lista de reproducción a todos</a>
      </div>
          <div class="col-sm-8 collapse" id="rightSection">
            <h4 id="kioscoListas"></h4>
            <div class="d-flex justify-content-end">
              <button type="button" name="button" class="btn btn-danger" style="cursor:pointer;" ><i class="fas fa-ban"></i> Eliminar</button>
              <button id="addPL" type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalProgramarLista"><i class="fas fa-plus"></i> Agregar</button>
            </div>


            <table class="table table-hover table-bordered mt-2">
              <thead class="">
                <tr>
                  <th scope="col" class="text-center">Lista de reproducción</th>
                  <th scope="col" class="text-center">Hora de inicio</th>
                  <th scope="col" class="text-center">D</th>
                  <th scope="col" class="text-center">L</th>
                  <th scope="col" class="text-center">M</th>
                  <th scope="col" class="text-center">M</th>
                  <th scope="col" class="text-center">J</th>
                  <th scope="col" class="text-center">V</th>
                  <th scope="col" class="text-center">S</th>
                  <th scope="col" class="text-center">Acciones</th>
                </tr>
              </thead>
              <tbody  id="rows">

              </tbody>
            </table>

          </div>
        </div>

      </div>

      <!-- MODAL NUEVA LISTA DE REPRODUCCI�N -->
      <div class="modal fade" id="modalProgramarLista" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalEditFiles"><h3>Programar lista de reproducción</h3></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>

                <div id="modal-bodyNewsFiles" class="modal-body">
                  <h4 class="text-center pt-2">Asignar o editar lista de reproducción</h4>
                    <div class="container row text-center d-flex justify-content-center mt-5">
                      <div class="">
                        <label for="lista" class="form-control-label">Lista de reproducción:</label>
                        <select id="selectList" class="form-control" name="">
                          <c:forEach items="${lista}" var="dato">
                              <option value="${dato.id}">${dato.nombre}</option>
                          </c:forEach>
                        </select>
                      </div>
                      <div class="ml-5">
                        <label for="horaInicial" class="form-control-label">Hora inicio:</label>
                        <input type="time" class="form-control mr-1" id="horaInicial">
                      </div>
                    </div>
                    <div class="mt-5">
                      <label class="text-center">Días de la semana activos: </label>
                      <table class="table table-hover mt-2">
                          <thead class="">
                            <tr>
                              <th scope="col" class="text-center">D</th>
                              <th scope="col" class="text-center">L</th>
                              <th scope="col" class="text-center">M</th>
                              <th scope="col" class="text-center">M</th>
                              <th scope="col" class="text-center">J</th>
                              <th scope="col" class="text-center">V</th>
                              <th scope="col" class="text-center">S</th>
                            </tr>
                          </thead>
                          <tbody>
                              <tr>
                                <td class="text-center"><input id="domingo1" class="form-check-input ml-1" type="checkbox" value="true" style="cursor:pointer;"></td>
                                <td class="text-center"><input id="lunes1" class="form-check-input ml-1" type="checkbox" value="true" style="cursor:pointer;"></td>
                                <td class="text-center"><input id="martes1" class="form-check-input ml-1" type="checkbox" value="true" style="cursor:pointer;"></td>
                                <td class="text-center"><input id="miercoles1" class="form-check-input ml-1" type="checkbox" value="true" style="cursor:pointer;"></td>
                                <td class="text-center"><input id="jueves1" class="form-check-input ml-1" type="checkbox" value="true" style="cursor:pointer;"></td>
                                <td class="text-center"><input id="viernes1" class="form-check-input ml-1" type="checkbox" value="true" style="cursor:pointer;"></td>
                                <td class="text-center"><input id="sabado1" class="form-check-input ml-1" type="checkbox" value="true" style="cursor:pointer;"></td>
                              </tr>

                          </tbody>
                      </table>
                      <input id="idKioH" type="hidden" name="button">
                      <input id="selTipo" type="hidden" name="button">
                    </div>
                </div>

                <div class="modal-footer">
                  <button id="btnProgramarLista" type"button" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>

          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCI�N -->

      <!-- MODAL BORRAR LISTA DE REPRODUCCI�N-->
      <div class="modal fade" id="modalMultProgramacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalCorteCaja"> <h2 class="text-center">Programar listas de reproducción</h2></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="ProgMultListas">
                <div id="modal-bodyCorteCaja" class="modal-body">

                 <div class="row">
                  <div class="col-sm-3 ml-3">
                   <h5 class="text-center">Kioscos seleccionados</h5>
                    <table class="table table-hover mt-2">
                        <thead class="">

                        </thead>
                        <tbody class="text-center">
                           <tbody id="kioscos" class="my-tbody">

                           </tbody>
                        </tbody>

                    </table>
                  </div>
                  <div class="col-sm-8">
                    <div class="container row text-center d-flex justify-content-center mt-5">
                      <div class="">
                        <label for="lista" class="form-control-label">Lista de reproducción:</label>
                        <select id="selectMultList" class="form-control" name="">
                          <c:forEach items="${lista}" var="dato">
                              <option value="${dato.id}">${dato.nombre}</option>
                          </c:forEach>
                        </select>
                      </div>
                      <div class="ml-5">
                        <label for="horaInicial" class="form-control-label">Hora inicio:</label>
                        <input type="time" class="form-control mr-1" id="horaInicial1">
                      </div>
                    </div>
                    <h3 class="text-center mt-5">Días: </h3>
                    <table class="table table-hover mt-2">
                        <thead class="">
                          <tr>
                            <th scope="col" class="text-center">D</th>
                            <th scope="col" class="text-center">L</th>
                            <th scope="col" class="text-center">M</th>
                            <th scope="col" class="text-center">M</th>
                            <th scope="col" class="text-center">J</th>
                            <th scope="col" class="text-center">V</th>
                            <th scope="col" class="text-center">S</th>
                          </tr>
                        </thead>
                        <tbody>
                            <tr>
                              <td class="text-center"><input id="domingo" class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input id="lunes"class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input id="martes" class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input id="miercoles" class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input id="jueves" class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input id="viernes" class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input id="sabado" class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                            </tr>

                        </tbody>
                    </table>
                  </div>
                 </div>

                </div>
                <div class="modal-footer">
                  <a id="btnMultListKio" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</a>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
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
