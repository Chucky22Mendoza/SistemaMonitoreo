<%--
    Document   : Informacion_Kiosco
    Created on : 23/11/2018, 01:34:39 AM
    Author     : Jesús Mendoza Verduzco
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--Inicia código de la vista de Kioskos-->
<div id="vistaKiosko" class="col-md-10 collapse">
  <div class="">
    <hr>
      <c:forEach items="${kiosco_gen}" var="dato">
        <h4 id = "${dato.id_kiosco}">
          <a>
            <a>${dato.nombre}</a>
            <a> - Agencia: </a>
            <a>${dato.agencia}</a>
          </a>
        </h4>
      </c:forEach>
    <hr>
      <div class="container">
        <div class="row">
          <!--Inicia código de la columna de la izquierda-->
          <div class="col-md-6 text-left">
            <hr>
            <div class="container">
              <div class="row">
                <c:forEach items="${kiosco_gen}" var="dato">
                  <div class="col-md-5 text-center font-weight-bold">
                    <i class="fas fa-desktop" style="width: 75%;height: 75%"></i>
                    <c:if test="${dato.id_status == 1}">
                      <a id="correcto" class="text-success" >Correcto<i class="fas fa-desktop ml-1"></i></a><br>
                    </c:if>
                    <c:if test="${dato.id_status == 2}">
                      <a id="alerta" class="text-warning">En alerta<i class="fas fa-exclamation-triangle ml-1"></i></a><br>
                    </c:if>
                    <c:if test="${dato.id_status == 3}">
                      <a id="desconectado" class="text-danger">Desconectado<i class="fas fa-plug ml-0"></i></a><br>
                    </c:if>
                    <c:if test="${dato.id_status == 4}">
                      <a id="desconectado" class="text-danger">Desconectado<i class="fas fa-plug ml-0"></i></a><br>
                    </c:if>
                    <!--Aquí se encuentran las otras opciones que pueden salir, solo mandarlas a llamar-->
                  </div>
                  <div class="col-md-7">
                    <a><a class="font-weight-bold">Nombre: </a><a class="ml-2" id="nombreDelKiosco">${dato.nombre}</a></a><br>
                    <a><a class="font-weight-bold">Agencia: </a><a class="ml-2" id="agenciaKiosco">${dato.agencia}</a></a><br>
                    <a><a class="font-weight-bold">Ubicación: </a><a class="ml-2" id="ubicacionKiosco">${dato.ubicacion}</a></a><br>
                    <a><a class="font-weight-bold">IP: </a><a class="ml-2" id="IPKiosco">${dato.ip}</a></a>
                  </div>
                </c:forEach>

              </div>
            </div>
            <hr>
              <section class="text-inline">
                <a href="#">
                  <a class="">T. de refrescado: </a><a id="tiempoRefresacado">60</a> <a> seg.</a>
                  <a class="">Última actualización hace: </a><a id="ultimaActualizacion">30</a><a> seg.</a>
                </a>
              </section>
              <!--Inicia Código de la alerta de la vista de Kioskos-->
              <div class="bg-warning rounded mt-3" id="alertaVistaAgencia">
                <div class="container mt-2">
                  <div class="row">
                    <div class="col-md-1">
                      <i class="icono izquierda fas fa-exclamation-triangle mt-2"></i>
                    </div>
                    <div class="col-md-10 my-1">
                      <h5 id = "kioscoAlerta">
                        <a>
                          <a>Este kiosco tiene </a>
                          <a id="numeroKioscoAlerta">${numAlertas} </a>
                          <a>alertas</a>
                        </a>
                      </h5>

                    </div>
                    <div class="col-md-1">
                      <i class="fas fa-share-square mt-2 mr-2"></i>
                    </div>
                  </div>
                </div>
              </div>
              <!--Termina código de alerta de la vista de Kioskos-->

              <!--Inicia código de los dispositivos vending-->
              <h5 class="mt-4 font-weight-bold">Dispositivos vending</h5>
              <hr>
                <div class="row">

                  <div class="col-md-5">
                    <c:forEach items="${dv}" var="dato">
                        <h6 style="font-size: 15px;">${dato.nombre}</h6>
                    </c:forEach>
                  </div>

                    <c:set var = "contador2" value = "${0}"/>
                <div class="col-md-1">
                    <c:forEach items="${dv}" var="dato">
                        <c:if test="${dato.status == true}">
                          <h6><i class="fas fa-check-circle text-success"></i></h6>
                        </c:if>
                        <c:if test="${dato.status == false}">
                          <h6><i class="fas fa-times-circle text-danger"></i></h6>
                        </c:if>
                    </c:forEach>
                </div>

              </div>
            <hr>
            <!--Temrina codigo de dispositivos vending-->

            <!--Inicia codigo de folios disponibles-->
            <h5 class="mt-4 font-weight-bold">Folios Disponibles</h5>
            <hr>
            <div class="container">
              <table class="table table-sm">
                <thead>
                  <tr>
                    <th scope="col">Impresora</th>
                    <th scope="col">Folio inicial</th>
                    <th scope="col">Folio final</th>
                    <th scope="col">Total</th>
                  </tr>
                </thead>
                <tbody>

                    <c:forEach items="${impresora}" var="dato">
                      <tr>
                        <th scope="row">${dato.nombre}</th>
                        <td>${dato.folio_inicial}</td>
                        <td>${dato.folio_final}</td>
                        <td>${dato.total}</td>
                      </tr>
                    </c:forEach>

                </tbody>
              </table>
            </div>
            <hr>
            <!--Termina codigo de folios disponibles-->

            <!--Inicia el código de los botones-->
            <div class="container text-center">
              <div class="row">

                  <c:forEach items="${kiosco_gen}" var="dato">
                    <div class="col-md-6">
                      <button id="btn_mantenimiento" value="${dato.id_kiosco}" type="button" class="btn btn-warning">Poner en mantenimiento</button>
                    </div>
                    <div class="col-md-6">
                      <button id="btn_apagar" value="${dato.id_kiosco}" type="button" class="btn btn-danger">Apagar kiosko</button>
                    </div>
                  </c:forEach>
              </div>
            </div>
            <!--Termina el código de los botones-->
          <!--Termina Código de la columa izquierda-->
        </div>
        <!--Inicia codigo d ela columna de la derecha-->
        <div class="col-md-6 text-right">
          <h5 class="text-center font-weight-bold"><i class="far fa-money-bill-alt mr-2"></i>Flujo de efectivo</h5>
          <hr>
            <a href="#">
              <a class="" style="font-size: 14px;">${corte}</a>
            </a>

            <!--Inicia código de efectivo disponible para cambio-->
            <h5 class="font-weight-bold mt-4">Efectivo disponible para cambio</h5>
            <hr>
              <div class="container">
                <p href="#" class="text-right">
                  <a><strong>Total: </strong></a><a id="totalCambioDisponible">${total_disp}</a>
                </p>

                <h5 class="font-weight-bold text-center">Denominaciones</h5>
                <hr>
                  <!--Empieza el código de denominaciones-->
                  <div class="container">
                    <div class="row">

                      <div class="text-center">
                        <c:forEach items="${disp_x_den}" var="dato">
                          <c:set var = "total" value = "${dato.cantidad_total}"/>
                          <c:set var = "min" value = "${dato.cantidad_minima}"/>

                            <c:if test="${total <= min}">
                              <h6  class="text-danger"><strong>${dato.nombre}: </strong>${dato.cantidad_total}</h6>
                            </c:if>
                            <c:if test="${total > min}">
                              <h6><strong>${dato.nombre}: </strong>${dato.cantidad_total}</h6>
                            </c:if>
                        </c:forEach>
                      </div>

                    </div>
                  </div>
                  <!--Temrina código de denominaciones-->
              </div>
              <hr>
            <!--Termina codigo de efectivo disponible para cambio-->

            <!--Inicia codigo de efectivo recibido-->
            <h5 class="font-weight-bold mt-4">Efectivo recibido</h5>
            <hr>
              <div class="container">
                <p href="#" class="text-right">
                  <a><strong>Total: </strong></a><a id="totalCambioRecibido">${total_recibido}</a>
                </p>

                <!--Inicia código de denominaciones del efectivo recibido-->
                <h5 class="font-weight-bold text-center">Denominaciones</h5>
                <hr>
                  <div class="row">


                  <div class="text-center">
                    <c:forEach items="${total_x_den}" var="dato">
                        <h6 href="#" class="text-left">
                          <a><strong>${dato.nombre}: </strong></a><a> ${dato.total}</a>
                        </h6>
                    </c:forEach>

                  </div>
                  </div>
                <hr>
                <!--termina código de denominaciones del efectivo recibido-->

                <!--Inicia código de nivel de contenedores del efectivo recibido-->
                <h5 class="text-center font-weight-bold mt-3">Nivel de contenedores</h5>
                <hr>
                  <div class="row">
                    <c:forEach items="${contenedor}" var="dato">
                      <div class="col-md-3">
                        <h6 href="#" class="text-center">
                          <a class=""><strong>Tot. de ${dato.nombre}: </strong></a><a>${dato.cantidad_actual}</a>
                        </h6>
                      </div>
                      <div class="col-md-3">
                        <canvas id="${dato.nombre}">

                        </canvas>
                      </div>
                      <script>
                        var calculado = ${dato.cantidad_total} - ${dato.cantidad_actual};
                        var nombre = ${dato.nombre}.id;

                        var cantidad_actual = ${dato.cantidad_actual};
                        var canvas = document.getElementById(nombre).getContext('2d');
                        var oilData = {
                		    datasets: [
                		        {
                		            data: [calculado, cantidad_actual],
                		            backgroundColor: [
                		                "#FF6384",
                		                "#63FF84",
                		            ]
                		        }]
                				};

                        var pieChart = new Chart(canvas, {
                				  type: 'pie',
                				  data: oilData
                				});
                      </script>

                    </c:forEach>


                  </div>
                <!--Termina código de nivel de contenedores de efectivo recibido-->
              </div>
            <hr>
            <!--Termina codigo de efectivo recibido-->
        </div>
        <!--Termina el codigo de la columna d ela derecha-->
      </div>
  </div>
</div>
</div>

<script type="text/javascript">
  $('#btn_mantenimiento').on('click',function(){
    var id = $(this).attr('value');
    var datos = {
      id_kiosco : id
    };
		//ABRIMOS AJAX
		$.ajax({
			type:"POST",
			url:"mantenimiento.htm",
			data:datos,
			//MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
			beforeSend: function(){
				alertify.success('Cargando...');
			},
			error: function(error){
				//ERROR
				alertify.error("Error al cambiar status");
			},
			success:function(r){
				//SE HA COMPLETADO
        if(r == 1){
          alertify.success('Kiosco en mantenimiento');
          setTimeout(function(){

            //Update tabla en lugar de refresh y cerrar modal
            window.location.assign("home.htm");
          }, 1200);
        }else{
          alertify.error('Ocurrió un error inesperado, la transacción fue completada');
        }
			}
		});
		return false;
  });

  $('#btn_apagar').on('click',function(){
    var id = $(this).attr('value');
    var datos = {
      id_kiosco : id
    };

		//ABRIMOS AJAX
		$.ajax({
			type:"POST",
			url:"apagado.htm",
			data:datos,
			//MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
			beforeSend: function(){
				alertify.success('Cargando...');
			},
			error: function(error){
				//ERROR
				alertify.error("Error al apagar");
			},
			success:function(r){
				//SE HA COMPLETADO
        if(r == 1){
          alertify.success('Kiosco apagado');
          setTimeout(function(){

            //Update tabla en lugar de refresh y cerrar modal
            window.location.assign("home.htm");
          }, 1200);
        }else{
          alertify.error('Ocurrió un error inesperado, la transacción fue completada');
        }
			}
		});
		return false;
  });
</script>
