<%--
    Document   : Informacion_agencia
    Created on : 23/11/2018, 04:19:35 AM
    Author     : Jesús Mendoza Verduzco
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--Inicia código de la vista de la agencia-->
<div id="vistaAgencia" class="col-md-10 collapse" >
  <div class="">
    <hr>
      <h4>
        <a>
          <a>Agencia </a>
          <a id="tituloAgencia">${agencia}</a>
        </a>
      </h4>
    <hr>
  </div>
  <!--Inicia Código de la alerta-->
  <div class="bg-warning rounded" id="alertaVistaAgencia">
    <div class="container mt-2">
      <div class="row">
        <div class="col-md-1">
          <p class="icono izquierda fas fa-exclamation-triangle mt-2"></p>
        </div>
        <div class="col-md-10 my-1">
          <h4 id = "kioscoAlertas">
            <a>
              <a id="numeroKioscosAlerta">${num_alertas} </a>
              <a>Kioscos presentan alertas</a>
            </a>
          </h4>
        </div>
        <div class="col-md-1">
          <i class="icono izquierda fas fa-share-square mt-2"></i>
        </div>
      </div>
    </div>
  </div>
  <!--Termina código de alerta-->

  <div class="container mt-2">
    <div class="row">
      <div class="col-md-4">
        <!--Kioskos en Servicio-->
        <div class="container">
          <hr>
          <div class="row">
            <div class="col-md-6">
              <h5 class="text-success text-center" id="status1">${status1}</h5>
              <h5 class="text-success text-center">Kioskos en Servicio</h5>
            </div>
            <div class="col-md-6">
              <canvas id="kioscosServicio">

              </canvas>
            </div>
          </div>
          <hr>
        </div>
      </div>
      <div class="col-md-4">
        <!--Kioskos en Mantenimiento-->
        <div class="container">
          <hr>
          <div class="row">
            <div class="col-md-6">
              <h5 class="text-warning text-center" id="status2">${status2}</h5>
              <h5 class="text-warning text-center">Kioskos en Mantenimiento</h5>
            </div>
            <div class="col-md-6">
              <canvas id="kioscosMantenimiento">

              </canvas>
            </div>
          </div>
          <hr>
        </div>
      </div>
      <div class="col-md-4">
        <!--Kiosko Desconectado-->
        <div class="container">
          <hr>
          <div class="row">
            <div class="col-md-6">
              <h5 class="text-danger text-center" id="status3">${status3}</h5>
              <h5 class="text-danger text-center">Kioskos Desconectados</h5>
            </div>
            <div class="col-md-6">
              <canvas id="kioscoDesconectados">

              </canvas>
            </div>
          </div>
          <hr>
        </div>
      </div>
    </div>
    <div class="row mt-2">

  <script type="text/javascript">
      var canvas = document.getElementById('kioscosServicio').getContext('2d');
      var canvas2 = document.getElementById('kioscosMantenimiento').getContext('2d');
      var canvas3 = document.getElementById('kioscoDesconectados').getContext('2d');
      var oilData = {
        datasets: [
            {
                data: [${status1}, ${status2}, ${status3}],
                backgroundColor: [
                    "#FF6384",
                    "#63FF84",
                    "#84FF63",
                ]
            }]
      };

    var pieChart = new Chart(canvas, {
      type: 'pie',
      data: oilData
    });

    var pieChart2 = new Chart(canvas2, {
      type: 'pie',
      data: oilData
    });

    var pieChart3 = new Chart(canvas3, {
      type: 'pie',
      data: oilData
    });
  </script>

      <div class="col-md-6">
        <!--Alertas en el mes-->
        <hr>
        <h4 class="text-center">Alertas en el mes</h4>
        <canvas id="alertasMes">

        </canvas>
        <hr>
      </div>
      <script>
        var listaTrue=[];
        var listaFalse=[];
        var kiosco=[];
      </script>

      <c:forEach items="${alertas_mes}" var="data">
        <c:set var="status" value = "${data.status}"/>
        <input id="irl" type="hidden" name="${data.nombre}" value="">
        <script>
          var nombre = $('#irl').attr('name');
          var dato = ${data.total};
          if(!kiosco.includes(nombre)){
            kiosco.push(nombre);
          }

        </script>

        <c:if test="${status == true}">
          <script>
            listaTrue.push(dato);
          </script>
        </c:if>
        <c:if test="${status == false}">
          <script>
            listaFalse.push(dato);
          </script>
        </c:if>
      </c:forEach>

  <script type="text/javascript">
      var canvas4 = document.getElementById('alertasMes').getContext('2d');

      var densityData = {
        label: 'Alertas pendientes',
        data: listaFalse,
        backgroundColor: 'rgba(0, 99, 132, 0.6)',
        borderWidth: 0,
        yAxisID: "y-axis-density"
      };

      var gravityData = {
        label: 'Alertas atendidas',
        data: listaTrue,
        backgroundColor: 'rgba(99, 132, 0, 0.6)',
        borderWidth: 0,
        yAxisID: "y-axis-gravity"
      };

      var planetData = {
        labels: kiosco,
        datasets: [densityData, gravityData]
      };

      var chartOptions = {
        scales: {
          xAxes: [{
            barPercentage: 1,
            categoryPercentage: 0.6
          }],
          yAxes: [{
            id: "y-axis-density"
          }, {
            id: "y-axis-gravity"
          }]
        },
        legend: {
          display: true,
          position: 'bottom',
          labels: {
            boxWidth: 80,
            fontColor: 'black'
          }
        }
      };

      var barChart2 = new Chart(canvas4, {
        type: 'bar',
        data: planetData,
        options: chartOptions
      });
  </script>
      <div class="col-md-6">
        <!--Disponibilidad de kioskos en el mes-->
        <hr>
        <h4 class="text-center">Disponibilidad de kioskos en el mes</h4>
        <canvas id="DisponibilidadKioscos">

        </canvas>
        <hr>
      </div>

  <script>
      var canvas5 = document.getElementById('DisponibilidadKioscos').getContext('2d');
      var dataFirst = {
          label: "Alertas atendidas",
          data: listaTrue,
          lineTension: 0.3,
          fill: false,
          borderColor: 'red',
          backgroundColor: 'transparent',
          pointBorderColor: 'red',
          pointBackgroundColor: 'lightgreen',
          pointRadius: 5,
          pointHoverRadius: 15,
          pointHitRadius: 30,
          pointBorderWidth: 2,
          pointStyle: 'rect'
        };

      var dataSecond = {
          label: "Alertas pendientes",
          data: listaFalse,
          lineTension: 0.3,
          fill: false,
          borderColor: 'purple',
          backgroundColor: 'transparent',
          pointBorderColor: 'purple',
          pointBackgroundColor: 'lightgreen',
          pointRadius: 5,
          pointHoverRadius: 15,
          pointHitRadius: 30,
          pointBorderWidth: 2
        };

      var speedData = {
        labels: ["Día 1", "Día 2", "Día 3", "Día 4", "Día 5", "Día 6", "Día 7"],
        datasets: [dataFirst, dataSecond]
      };

      var chartOptions = {
        legend: {
          display: true,
          position: 'bottom',
          labels: {
            boxWidth: 80,
            fontColor: 'black'
          }
        }
      };

      var lineChart = new Chart(canvas5, {
        type: 'line',
        data: speedData,
        options: chartOptions
      });
  </script>
    </div>
  </div>
</div>
