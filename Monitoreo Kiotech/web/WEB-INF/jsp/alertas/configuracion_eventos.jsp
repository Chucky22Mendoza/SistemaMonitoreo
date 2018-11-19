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

      <spring:url value="/resources/js/eventos.js" var="eventosJS" />
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
      <spring:url value="/resources/css/table-scrollable.css" var="tableCSS" />
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
      <link rel="stylesheet" href="${tableCSS}">
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
            <c:set var="contador" value="${0}"></c:set>
            <c:forEach items="${evento}" var="dato">
              <c:set var="contador" value="${contador+1}"></c:set>
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
                <c:if test="${contador == 13}">
                    <td class="text-center">
                      <a class="ico-conf" data-toggle="modal" data-target="#modalMinFolios">
                         Configurar <i class="fas fa-cog icono"></i>
                      </a>
                    </td>
                </c:if>
                <c:if test="${contador == 14}">
                    <td class="text-center">
                      <a class="ico-conf" data-toggle="modal" data-target="#modalDenominaciones">
                         Configurar <i class="fas fa-cog icono"></i>
                      </a>
                    </td>
                </c:if>
                <c:if test="${contador == 15}">
                    <td class="text-center">
                      <a class="ico-conf" data-toggle="modal" data-target="#modalContenedores">
                         Configurar <i class="fas fa-cog icono"></i>
                      </a>
                    </td>
                </c:if>
                <c:if test="${contador == 16}">
                    <td class="text-center">
                      <a class="ico-conf" data-toggle="modal" data-target="#modalCorteCaja">
                         Configurar <i class="fas fa-cog icono"></i>
                      </a>
                    </td>
                </c:if>
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
                  <input id="folios" class="form-control col-sm-3" type="number" class="form-input ml-2" name="" value="${minFolio}" min="0">
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

      <!-- MODAL BORRAR LISTA DE REPRODUCCI�N-->
      <div class="modal fade" id="modalDenominaciones" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalDenominaciones"> <h2 class="text-center">Configuración de Evento 13</h2></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="Denominaciones">
                <div id="modal-bodyDenominaciones" class="modal-body">
                 <h3 class="text-center">Cantidad Mínima de: </h3>
                  <hr>
                  <div class="modal-body row d-flex justify-content-center">
                    <label for="mon1" class="form-control-label col-sm-5">Monedas de $1: </label>
                    <input id="mon1" type="number" class="form-control col-sm-3 ml-2" name="" value="10" min="5">
                  </div>
                  <div class="modal-body row mt-2 d-flex justify-content-center">
                    <label for="mon5" class="form-control-label col-sm-5">Monedas de $5: </label>
                    <input id="mon5" class="form-control col-sm-3 ml-2"  type="number" name="" value="10" min="5">
                  </div>
                  <div class="modal-body row mt-2 d-flex justify-content-center">
                    <label for="mon10" class="form-control-label col-sm-5">Monedas de $10: </label>
                    <input id="mon10" class="form-control col-sm-3 ml-2"  type="number" name="" value="10" min="5">
                  </div>
                  <div class="modal-body row mt-2 mb-5 d-flex justify-content-center">
                    <label for="bil50" class="form-control-label col-sm-5">Billetes de $50: </label>
                    <input id="bil50" class="form-control col-sm-3 ml-2" type="number" name="" value="10" min="5">
                  </div>
                </div>
                <div class="modal-footer">
                  <a id="btnDenominaciones" class="btn btn-warning ml-2"><i class="fas fa-trash-alt"></i> Aceptar</a>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL LISTA DE REPRODUCCI�N -->
      <!-- MODAL BORRAR LISTA DE REPRODUCCI�N-->
      <div class="modal fade" id="modalContenedores" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalContenedores"> <h2 class="text-center">Configuración de Evento 14</h2></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="Contenedores">
                <div id="modal-bodyContenedores" class="modal-body">
                 <h3 class="text-center">Cantidad Máxima de: </h3>
                  <hr>
                  <div class="modal-body row d-flex justify-content-center">
                    <label for="monedas" class="form-control-label col-sm-3">Monedas: </label>
                    <input id="monedas" type="number" class="form-control col-sm-3 ml-2" value="2500" min="500">
                  </div>
                  <div class="modal-body row mt-2 d-flex justify-content-center">
                    <label for="billetes" class="form-control-label col-sm-3">Billetes: </label>
                    <input id="billetes" class="form-control col-sm-3 ml-2"  type="number" value="1250" min="250">
                  </div>
                </div>
                <div class="modal-footer">
                  <a id="btnContenedores" class="btn btn-warning ml-2"><i class="fas fa-trash-alt"></i> Aceptar</a>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL LISTA DE REPRODUCCI�N -->
      <!-- MODAL BORRAR LISTA DE REPRODUCCI�N-->
      <div class="modal fade" id="modalCorteCaja" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalCorteCaja"> <h2 class="text-center">Configuración de Evento 15</h2></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="CorteCaja">
                <div id="modal-bodyCorteCaja" class="modal-body">
                 <h3 class="text-center">Horario para realizar corte de caja</h3>
                  <hr>
                 <div class="row">
                  <div class="col-sm-4">
                   <h3 class="text-center">Kioscos</h3>
                    <table class="table table-hover mt-2">
                        <thead class="">
                          <tr>
                           <th >
                           </th>
                            <th scope="col" class="text-center">
                             <div class="form-check">
                              <input class="form-check-input" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                              <label class="form-check-label ml-1" for="cbGen">
                               Seleccionar todos
                              </label>
                             </div>
                            </th>
                          </tr>
                        </thead>
                        <tbody class="">
                           <table class="my-tbody">
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 1</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 2</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value=""  style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 3</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 4</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 5</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 6</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 7</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 8</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 9</td>
                            </tr>
                            <tr class="tr">
                              <td class="text-center td"><input class="form-check-input ml-4" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center td">Kiosco 10</td>
                            </tr>
                            <div class="cl"></div>
                           </table>
                        </tbody>

                    </table>
                  </div>
                  <div class="col-sm-8">
                    <div class="modal-body row d-flex justify-content-center mt-5">
                      <label for="horaInicial" class="form-control-label col-sm-3">Hora inicio: </label>
                      <input type="time" class="form-control mr-1 col-sm-2" id="horaInicial">

                      <label for="horaFin" class="form-control-label col-sm-3">Hora fin: </label>
                      <input type="time" class="form-control mr-1 col-sm-2" id="horaFin">
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
                              <td class="text-center"><input class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                              <td class="text-center"><input class="form-check-input ml-1" type="checkbox" value="" style="cursor:pointer;"></td>
                            </tr>

                        </tbody>
                    </table>
                  </div>
                 </div>

                </div>
                <div class="modal-footer">
                  <a id="btnCorteCaja" class="btn btn-warning ml-2"><i class="fas fa-trash-alt"></i> Aceptar</a>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL LISTA DE REPRODUCCI�N -->

      <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
      <script src="${jquery}"></script>
      <script src="${eventosJS}"></script>
      <script src="${btJS}"></script>
      <script src="${alertifyJS}"></script>
      <script src="${spinnerJS}"></script>
      <script src="${programacionJS}"></script>
      <script src="${menuJS}"></script>
      <script src="${AJAX}"></script>
    </body>
</html>
