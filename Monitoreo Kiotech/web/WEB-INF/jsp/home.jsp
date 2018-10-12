<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <spring:url value="/resources/js/jquery.js" var="jquery" />
        <spring:url value="/resources/js/home.js" var="homeJS" />
        <spring:url value="/resources/js/menu.js" var="menuJS" />
        <spring:url value="/resources/css/home.css" var="homeCSS" />
        <spring:url value="/resources/images/logo.png" var="logo" />
        <spring:url value="/resources/images/home.png" var="homeIMG" />
        <spring:url value="/resources/css/bootstrap/bootstrap.css" var="btCSS" />
        <spring:url value="/resources/js/bootstrap/bootstrap.js" var="btJS" />
        <spring:url value="/resources/js/homeAJAX.js" var="AJAX" />
        <spring:url value="/resources/alertifyjs/css/alertify.css" var="alertifyCSS" />
        <spring:url value="/resources/css/spinner.css" var="spinnerCSS" />
        <spring:url value="/resources/js/spinner.js" var="spinnerJS" />
        <spring:url value="/resources/alertifyjs/alertify.js" var="alertifyJS" />

        <link rel="stylesheet" href="${homeCSS}">
        <link rel="shortcut icon" href="${logo}">
        <link rel="shortcut icon" href="${homeIMG}">
        <link rel="stylesheet" href="${btCSS}">
        <link rel="stylesheet" href="${alertifyCSS}">
        <link rel="stylesheet" href="${spinnerJS}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>


    </head>

    <body>

      <!-- Image and text -->
      <nav class="navbar navbar-light " style="background-color:#303a4c">
        <a class="navbar-brand text-center color-light " href="#" style="color:#fff">
         <div class="card-body d-flex justify-content-between align-items-center">
            <img src="${logo}" width="200px" class="">
          Sistema de Monitoreo y Publicidad
          
	<button type="button" name="button" class="btn btn-warning" style="cursor:pointer"><i class="fa fa-user-circle"></i> Nombre Usuario </button>
         </div>
        </a>
      </nav>

      <!-- Inico de barra de Menú-->
      <ul class="mt-5">
        <ul class="tabs col-sm-10">
          <li><a href="#tab1" id="pestaña1"><span class="fas fa-desktop "></span> <span class="tab-text">Monitoreo de Kiosco</span></a></li>
          <li><a href="#tab2" id="pestaña2"><span class="fas fa-exclamation-circle"></span> <span class="tab-text">Alertas</span></a></li>
          <li><a href="#tab3" id="pestaña3"><span class="fas fa-play-circle"></span> <span class="tab-text">Publicidad</span></a></li>
        </ul>
      </ul>
      <!--Fin de barra de Menú -->
      <section class="container secciones">
        <article id="tab1">
             <!-- Inico de barra de MenÃº Monitoreo de Kiosko-->
   
        </article>
          
        <article id="tab2">
             <!-- Inico de barra de MenÃº Alertas-->
             <ul class="mt-5">
            <ul class="mtab d-flex justify-content-left">
              <li><a href="#t11" id="pest1"><span class="fa fa-history"></span> <span class="tab-text">Historial de Alertas</span></a></li>
              <li><a href="#t22" id="pest2"><span class="fa fa-truck"></span> <span class="tab-text">Configuracion Medios de Envio</span></a></li>
              <li><a href="#t33" id="pest3"><span class="fas fa-calendar-alt"></span> <span class="tab-text">Configuracion de eventos</span></a></li>
              <li><a href="#t44" id="pest4"><span class="fa fa-user-plus"></span> <span class="tab-text">Asignacion de Usuarios</span></a></li>
            </ul>
          </ul>
             <!--Fin de barra de MenÃº Alertas-->
           
             <section class="secciones2">
                 <!--Seccion tabla 1 Historial de alertas -->
              <article id="t11">
              <div id="" class="">
                <div class="form-check">
                  
                    <button type="button" name="button" class="btn btn-info" style="cursor:pointer;">
                        <i class="fa fa-info"> </i>
                        Opciones Avanzadas</button>
                </div>
              </div>

              <table class="table table-hover mt-2">
                <thead class="">
                  <tr>
                    <th scope="col" class="text-center"> </th>
                    <th scope="col" class="text-center">ID</th>
                    <th scope="col" class="text-center">Fecha y Hora</th>
                    <th scope="col" class="text-center">Tipi de Alerta</th>
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
            </article>
                 <!--Fin de Seccion tabla 1 Historial de alertas -->
                 
                 <!--Seccion tabla 2 configuracion de medios de envio -->
                 <article id="t22"> 
                 
                 </article>
                 <!--Fin de Seccion tabla 2 configuracion de medios de envio -->
                 
                 <!--Seccion tabla 3 Configuracion de eventos -->
                 <article id="t33"> 
                 <table class="table table-hover mt-2">
                <thead class="">
                  <tr>
                    <th scope="col" class="text-center"> </th>
                    <th scope="col" class="text-center">ID</th>
                    <th scope="col" class="text-center">Evento (Tipo de Alerta)</th>
                    <th scope="col" class="text-center">Mensaje</th>
                    <th scope="col" class="text-center">Activo</th>
                    <th scope="col" class="text-center">Acciones</th>
                  </tr>
                </thead>
                      </table>
                     
                 </article>
                 <!--Fin de Seccion tabla 3 Configuracion de eventos -->
                 
                 <!--Seccion tabla 4 Asignacion de usuarios -->
                 <article id="t44">
                    
              <div id="" class="">
                <div class="form-check">
                  <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                  <label class="form-check-label ml-4" for="cbGen">
                    Seleccionar todos
                  </label>
                </div>
                <div class="d-flex justify-content-end">
                    <button type="button" name="button" class="btn btn-info" style="cursor:pointer;">
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
                    <th scope="col" class="text-center">Envio de Email</th>
                    <th scope="col" class="text-center">Envio de SMS</th>
                    <th scope="col" class="text-center">Acciones</th>
                  </tr>
                </thead>
                      </table>
                 </article>
                 <!--Fin de Seccion tabla 4 Asignacion de usuarios -->
                 
             </section>
             
             
        </article>
        <article id="tab3">

          <!-- Inico de barra de Menú publicidad-->
          <ul class="mt-5">
            <ul class="minitab d-flex justify-content-left">
              <li><a href="#t1" id="pest1"><span class="fas fa-file-archive "></span> <span class="tab-text">Archivos multimedia</span></a></li>
              <li><a href="#t2" id="pest2"><span class="fas fa-list-ul"></span> <span class="tab-text">Listas de reproducción</span></a></li>
              <li><a href="#t3" id="pest3"><span class="fas fa-tasks"></span> <span class="tab-text">Programación de listas</span></a></li>
            </ul>
          </ul>
          <!--Fin de barra de Menú publicidad-->

          <section class="secciones2">
              <!--Seccion de tabla 1- Archivos Multimedia-->
            <article id="t1">
              <h4>Archivos multimedia existentes en el servidor</h3>
              <div id="" class="">
                <div class="form-check">
                  <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                  <label class="form-check-label ml-4" for="cbGen">
                    Seleccionar todos
                  </label>
                </div>
                <div class="d-flex justify-content-end">
                  <button type="button" name="button" class="btn btn-danger" style="cursor:pointer;"><i class="fas fa-ban"></i> Eliminar</button>
                  <button type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalNuevoArchivo"><i class="fas fa-cloud-upload-alt"></i> Subir nuevo archivo</button>
                </div>
              </div>

              <table class="table table-hover mt-2">
                <thead class="">
                  <tr>
                    <th scope="col" class="text-center"> </th>
                    <th scope="col" class="text-center">ID</th>
                    <th scope="col" class="text-center">Nombre archivo</th>
                    <th scope="col" class="text-center">Tipo</th>
                    <th scope="col" class="text-center">Duración (s)</th>
                    <th scope="col" class="text-center">Acciones</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${File}" var="dato">

                    <tr>
                      <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
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
            </article>
              <!--Seccion de tabla 2-Listas de Reproduccion-->
            <article id="t2">
              <h4>Listas de Reprocuccion Existentes</h3>
              <div id="" class="">
                <div class="form-check">
                  <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                  <label class="form-check-label ml-4" for="cbGen">
                    Seleccionar todos
                  </label>
                </div>
                <div class="d-flex justify-content-end">
                  <button type="button" name="button" class="btn btn-danger" style="cursor:pointer;" ><i class="fas fa-ban"></i> Eliminar</button>
                  <button type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer;" href="#" data-toggle="modal" data-target="#modalNuevaLista"><i class="fas fa-plus"></i> Nueva Lista</button>
                </div>
              </div>

              <table class="table table-hover mt-2">
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

                    <tr>
                      <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                      <td class="text-center">${dato.id}</td>
                      <td class="text-center">${dato.nombre}</td>
                      <td class="text-center">${dato.descripcion}</td>
                      <td class="text-center">
                        <a id="${dato.id}" name="${dato.nombre}"  class="ico-program mr-1" data-toggle="modal" data-target="#modalAgregarArchivos">
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
            </article>
              <!--Seccion de tabla 3- Programacion de Listas -->
            <article id="t3">
              <h4> Listas Programadas </h3>
              <div id="" class="">
                <div class="form-check">
                  <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                  <label class="form-check-label ml-4" for="cbGen">
                    Seleccionar todos
                  </label>
                </div>
                <div class="d-flex justify-content-end" style="margin-top:-50px;">
                  <button type="button" name="button" class="btn btn-danger" style="cursor:pointer"><i class="fas fa-ban"></i> Eliminar</button>
                  <button type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer"><i class="fa fa-wrench"></i> Editar </button>
                </div>
              </div>

              <table class="table table-hover mt-2">
                <thead class="">
                  <tr>
                    <th scope="col" class="text-center"> </th>
                    <th scope="col" class="text-center">ID</th>
                    <th scope="col" class="text-center">Nombre de Lista Programada</th>
                    <th scope="col" class="text-center">Descripcion</th>
                    <th scope="col" class="text-center">Acciones</th>
                  </tr>
                </thead>
                <tbody>
               <!-- ------------------------ -->
               <!-- ------------------------ -->
               <!-- MODIFICAR CHUKY -->
               <!-- ------------------------ -->
               <!-- ------------------------ -->
                  <c:forEach items="${File}" var="dato">

                    <tr>
                      <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                      <td class="text-center">${dato.id}</td>
                      <td class="text-center">${dato.nombre}</td>
                      <td class="text-center">${dato.tipo}</td>
                      <td class="text-center">${dato.duracion}</td>
                      <td class="text-center">
                        <a id="${dato.id}" name="${dato.nombre}" value="${dato.nombre}-${dato.tipo}-${dato.duracion}" class="ico-edit" href="#" data-toggle="modal" data-target="#modalEditarArchivo">
                          <i class="fas fa-edit"></i>
                        </a>
                        <a href="PlayList_Delete/${dato.id}">
                          <i class="fas fa-trash-alt ico-del"></i>
                        </a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </article>
          </section>

        </article>
      </section>


      <!--SECCIÓN DE MODALES-->
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
                            <label for="duracion" class="col-sm-3 form-control-label">Duración:</label>
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

      <!-- MODAL EDITAR LISTA DE REPRODUCCIÓN-->
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
      <!-- FIN DEL MODAL EDITAR LISTA DE REPRODUCCIÓN -->

      <!-- MODAL BORRAR LISTA DE REPRODUCCIÓN-->
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
      <!-- FIN DEL MODAL LISTA DE REPRODUCCIÓN -->

      <!-- MODAL NUEVA LISTA DE REPRODUCCIÓN -->
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
                          <input class="form-control col-sm-8" id="nombreList" placeholder="Nombre de la lista de reproducción" type="text" name="nombreList" required="required">
                       </div>
                       <div class="col-sm-12 row d-flex justify-content-center align-items-center mt-3">
                          <label for="descripcion" class="col-sm-3 form-control-label">Descripción:</label>
                          <input class="form-control col-sm-8" id="descripcion" placeholder="Una pequeña descripción" type="text" name="descripcion" required="required">
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
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCIÓN -->

      <!-- MODAL NUEVA LISTA DE REPRODUCCIÓN -->
      <div class="modal fade" id="modalAgregarArchivos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <div id="titleModalNewsFiles"></div>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
              <form id="NewsFiles">
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
                        <th scope="col" class="text-center">ID</th>
                        <th scope="col" class="text-center">Nombre archivo</th>
                        <th scope="col" class="text-center">Tipo</th>
                        <th scope="col" class="text-center">Duración (s)</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${File}" var="dato">

                        <tr>
                          <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                          <td class="text-center">${dato.id}</td>
                          <td class="text-center">${dato.nombre}</td>
                          <td class="text-center">${dato.tipo}</td>
                          <td class="text-center">${dato.duracion}</td>
                        </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
                <div class="modal-footer">
                  <button id="nuevosArchivos" type"button" class="btn btn-info ml-2"><i class="fas fa-upload"></i> Aceptar</button>
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL NUEVA LISTA DE REPRODUCCIÓN -->

    <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
    <script src="${jquery}"></script>
    <script src="${btJS}"></script>
    <script src="${alertifyJS}"></script>
    <script src="${spinnerJS}"></script>
    <script src="${homeJS}"></script>
    <script src="${menuJS}"></script>
    <script src="${AJAX}"></script>

    </body>

</html>
