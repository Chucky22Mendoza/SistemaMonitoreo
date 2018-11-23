$(document).ready(function(){
	$('.mainu li:has(ul)').click(function(e){
		e.preventDefault();

		if ($(this).hasClass('activado')){
			$(this).removeClass('activado');
			$(this).children('ul').slideUp();
		} else {
			$('.mainu li ul').slideUp();
			$('.mainu li').removeClass('activado');
			$(this).addClass('activado');
			$(this).children('ul').slideDown();
		}
	});

/*	$(".divAgencia").on('click', function(){

		$(this).children('div').slideDown();

	});*/

	$(".kiosko").on('click', function(e) {
		e.preventDefault();

		var id = $(this).attr('id');
		var nombre_agencia = $(this).attr('value');
		var nombre_kiosco = $(this).attr('name');

		$('#nombreKiosco').replaceWith('<a id="nombreKiosco">' + nombre_kiosco + '</a>');
		$('#nombreAgencia').replaceWith('<a id="nombreAgencia">'+ nombre_agencia +'</a>');

		var datos = {
      id_kiosco : id
    };

		//ABRIMOS AJAX
		$.ajax({
			type:"POST",
			url:"kiosko.htm",
			data:datos,
			//MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
			beforeSend: function(){
				//alertify.success('Cargando...');
			},
			error: function(error){
				//ERROR

				alertify.alert("Error al cargar el Kiosco en cuestión");
			},
			success:function(r){
				//SE HA COMPLETADO

				$('#vistaAgencia').hide();
				$('#vistaSeleccion').hide();
				$("#vistaKiosko").show();

				var canvas6 = document.getElementById('totMonedas').getContext('2d');
				var canvas7 = document.getElementById('totBilletes').getContext('2d');

				var oilData = {
		    datasets: [
		        {
		            data: [133.3, 86.2],
		            backgroundColor: [
		                "#FF6384",
		                "#63FF84",
		            ]
		        }]
				};

				var pieChart = new Chart(canvas6, {
				  type: 'pie',
				  data: oilData
				});

				var pieChart2 = new Chart(canvas7, {
				  type: 'pie',
				  data: oilData
				});
			}
		});
		return false;
	});
/*
	$(".agencia").on('click', function(e) {
		e.preventDefault();

		var id_agencia = $(this).attr('id');
		var nombre_agencia = $(this).attr('name');

		$('#tituloAgencia').replaceWith('<a id="tituloAgencia">' + nombre_agencia + '</a>');

		var datos = {
      id_agencia : id_agencia
    };

		//ABRIMOS AJAX
		$.ajax({
			type:"POST",
			url:"agencia.htm",
			data:datos,
			//MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
			beforeSend: function(){
				//alertify.success('Cargando...');
			},
			error: function(error){
				//ERROR

				alertify.alert("Error al cargar la agencia en cuestión");
			},
			success:function(r){
				//SE HA COMPLETADO
				$("#vistaSeleccion").hide();
				$('#vistaAgencia').show();
				$('#vistaKiosko').hide();

				var canvas = document.getElementById('kioscosServicio').getContext('2d');
				var canvas2 = document.getElementById('kioscosMantenimiento').getContext('2d');
				var canvas3 = document.getElementById('kioscoDesconectados').getContext('2d');
				var canvas4 = document.getElementById('alertasMes').getContext('2d');
				var canvas5 = document.getElementById('DisponibilidadKioscos').getContext('2d');

				var oilData = {
			    datasets: [
			        {
			            data: [133.3, 86.2, 52.2],
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

		 ////////////////////////////////////7
				var densityData = {
				  label: 'Alertas pendientes',
				  data: [10, 7, 5, 2, 1, 0, 5, 3],
				  backgroundColor: 'rgba(0, 99, 132, 0.6)',
				  borderWidth: 0,
				  yAxisID: "y-axis-density"
				};

				var gravityData = {
				  label: 'Alertas atendidas',
				  data: [9, 13, 1, 0, 5, 3, 7, 8],
				  backgroundColor: 'rgba(99, 132, 0, 0.6)',
				  borderWidth: 0,
				  yAxisID: "y-axis-gravity"
				};

				var planetData = {
				  labels: ["Kiosco 1", "Kiosco 2", "Kiosco 3", "Kiosco 4", "Kiosco 5", "Kiosco 6", "Kiosco 7", "Kiosco 8"],
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
		//////////////////////////////////////////////////////////////////////7
				var dataFirst = {
				    label: "Kiosco 1",
				    data: [0, 59, 75, 20, 20, 55, 40],
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
				    label: "Kiosco 2)",
				    data: [20, 15, 60, 60, 65, 30, 70],
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
				  datasets: [dataFirst, dataSecond, dataFirst]
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
		////////////////////////////////////////////////////////////////////////
			}
		});
		return false;
	});
*/
	$('.btn-mainu').click(function(){
		$('.contenedor-mainu .mainu').slideToggle();
	});

$(window).resize(function(){
		if ($(document).width() > 450){
			$('.contenedor-mainu .mainu').css({'display' : 'block'});
		}

		if ($(document).width() < 450){
			$('.contenedor-mainu .mainu').css({'display' : 'none'});
			$('.mainu li ul').slideUp();
			$('.mainu li').removeClass('activado');
		}
	});

	$('.mainu li ul li a').click(function(){
		window.location.href = $(this).attr("href");
	});
});
