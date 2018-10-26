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
      <title>Proramación de listas</title>
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
                          <tr id="${dato.id}" name="${dato.nombre}" class="select primero" val="${dato.nombre}-${dato.agencia}">
                            <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                            <td class="text-center">${dato.id}</td>
                            <td class="text-center">${dato.nombre}</td>
                            <td class="text-center">${dato.agencia}</td>
                          </tr>
				        </form>
				    </c:if>
                    <c:if test = "${contador !=  1}">
                        <form>
                          <tr id="${dato.id}" name="${dato.nombre}" class="select" val="${dato.nombre}-${dato.agencia}">
                            <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                            <td class="text-center">${dato.id}</td>
                            <td class="text-center">${dato.nombre}</td>
                            <td class="text-center">${dato.agencia}</td>
                          </tr>
				        </form>
				    </c:if>
               </c:forEach>
            </tbody>
          </table>

          <div class="col-sm-8">
            <h4 id="kioscoListas"></h4>
            <div class="d-flex justify-content-end">
              <button type="button" name="button" class="btn btn-danger" style="cursor:pointer;" ><i class="fas fa-ban"></i> Eliminar</button>
              <button type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalNuevaLista"><i class="fas fa-plus"></i> Agregar</button>
            </div>
            <div id="" class="">
              <div class="form-check">
                <input class="form-check-input ml-4" type="checkbox" value="" id="cbGenListas" style="cursor:pointer;">
                <label class="form-check-label ml-4" for="cbGen">
                  Seleccionar todos
                </label>
              </div>
            </div>

            <table class="table table-hover table-bordered mt-2">
              <thead class="">
                <tr>
                  <th scope="col" class="text-center"> </th>
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
                 <c:forEach items="${programadas}" var="dato">
                    <c:set var="dom" value="${dato.d}"></c:set>
                    <c:set var="lun" value="${dato.l}"></c:set>
                    <c:set var="mar" value="${dato.ma}"></c:set>
                    <c:set var="mier" value="${dato.mi}"></c:set>
                    <c:set var="jue" value="${dato.j}"></c:set>
                    <c:set var="vie" value="${dato.v}"></c:set>
                    <c:set var="sab" value="${dato.s}"></c:set>
                  <tr>
                    <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                    <td id="nombreLista" class="text-center">${dato.nombreLista}</td>
                    <td id="horaInicio" class="text-center">${dato.hora_inicio}</td>
                    
                    <c:if test="${dom == true}">
                        <td class="text-center"><input id="D" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${dom == false}">
                        <td class="text-center"><input id="D" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>
                    
                    <c:if test="${lun == true}">
                        <td class="text-center"><input id="L" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${lun == false}">
                        <td class="text-center"><input id="L" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>
                    
                    <c:if test="${mar == true}">
                        <td class="text-center"><input id="Ma" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${mar == false}">
                        <td class="text-center"><input id="Ma" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>
                    
                    <c:if test="${mier == true}">
                        <td class="text-center"><input id="Mi" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${mier == false}">
                        <td class="text-center"><input id="Mi" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>
                    
                    <c:if test="${jue == true}">
                        <td class="text-center"><input id="J" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${jue == false}">
                        <td class="text-center"><input id="J" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>
                    
                    <c:if test="${vie == true}">
                        <td class="text-center"><input id="V" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${vie == false}">
                        <td class="text-center"><input id="V" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>
                    
                    <c:if test="${sab == true}">
                        <td class="text-center"><input id="S" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;" checked></td>
                    </c:if>
                    <c:if test="${sab == false}">
                        <td class="text-center"><input id="S" type="checkbox" class="mt-1 cbSelec" name="cbSelec" disabled="disabled" style="cursor:pointer;"></td>
                    </c:if>
                    
                    <td class="text-center">
                      <a id="${dato.id_lista_reproduccion}" name="${dato.nombreLista}" value="${dato.nombreLista}-${dato.hora_inicio}-${dato.d}-${dato.l}-${dato.ma}-${dato.mi}-${dato.j}-${dato.v}-${dato.s}" class="ico-edit" data-toggle="modal" data-target="#modalEditarArchivo">
                        <i class="fas fa-edit icono"></i>
                      </a>
                    </td>
                  </tr>
                 </c:forEach>
              </tbody>
            </table>

          </div>
        </div>

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
