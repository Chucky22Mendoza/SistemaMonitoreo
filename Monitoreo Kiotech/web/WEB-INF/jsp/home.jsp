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
        <spring:url value="/resources/css/bootstrap/bootstrap.min.css" var="btCSS" />
        <spring:url value="/resources/js/bootstap/bootstrap.min.js" var="btJS" />

        <link rel="stylesheet" href="${homeCSS}">
        <link rel="shortcut icon" href="${logo}">
        <link rel="shortcut icon" href="${homeIMG}">
        <link rel="stylesheet" href="${btCSS}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>


    </head>

    <body>

      <!-- Image and text -->
      <nav class="navbar navbar-light " style="background-color:#303a4c">
        <a class="navbar-brand text-center color-light " href="#" style="color:#fff">
          <img src="${logo}" width="200px" class="">
          Sistema de Monitoreo y Publicidad
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
        </article>
        <article id="tab2">
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
            <article id="t1">
              <h4>Archivos multimedia existentes en el servidor</h3>
              <div id="" class="">
                <div class="form-check">
                  <input class="form-check-input ml-4" type="checkbox" value="" id="cbGen" style="cursor:pointer;">
                  <label class="form-check-label ml-4" for="cbGen">
                    Seleccionar todos
                  </label>
                </div>
                <div class="d-flex justify-content-end" style="margin-top:-50px;">
                  <button type="button" name="button" class="btn btn-danger" style="cursor:pointer"><i class="fas fa-ban"></i> Eliminar</button>
                  <button type="button" name="button" class="btn btn-info ml-2" style="cursor:pointer"><i class="fas fa-cloud-upload-alt"></i> Subir nuevo archivo</button>
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
                  <tr>
                    <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                    <th  class="text-center" scope="row">1</th>
                    <td class="text-center">imagen1.jpg</td>
                    <td class="text-center">imagen</td>
                    <td class="text-center">60</td>
                    <td class="text-center"><span class="fas fa-edit ico-edit" data-toggle="modal" data-target="#modalEditarArchivo"></span> <i class="fas fa-trash-alt ico-del"></i></td>
                  </tr>
                  <tr>
                    <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                    <th  class="text-center" scope="row">2</th>
                    <td class="text-center">video1.mp4</td>
                    <td class="text-center">video</td>
                    <td class="text-center">60</td>
                    <td class="text-center"><span class="fas fa-edit ico-edit" data-toggle="modal" data-target="#modalEditarArchivo"></span> <i class="fas fa-trash-alt ico-del"></i></td>
                  </tr>
                  <tr>
                    <td class="text-center"><input type="checkbox" class="mt-1 cbSelec" name="cbSelec" style="cursor:pointer;"></td>
                    <th  class="text-center" scope="row">3</th>
                    <td class="text-center">imagen2.png</td>
                    <td class="text-center">imagen</td>
                    <td class="text-center">60</td>
                    <td class="text-center"><span class="fas fa-edit ico-edit" data-toggle="modal" data-target="#modalEditarArchivo"></span> <i class="fas fa-trash-alt ico-del"></i></td>
                  </tr>
                </tbody>
              </table>
            </article>
            <article id="t2">
              <p>Segunda sección</p>
            </article>
            <article id="t3">
              <p>Tercera sección</p>
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
              <h5 class="modal-title" id="exampleModalLabel">Editar archivo</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>

              <div class="modal-body">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-success">Aceptar</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
              </div>

          </div>
        </div>
      </div>
      <!-- FIN DEL MODAL EDITAR ARCHIVO -->



    <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
    <script src="${jquery}"></script>
    <script src="${btJS}"></script>
    <script src="${homeJS}"></script>
    <script src="${menuJS}"></script>

    </body>

</html>
