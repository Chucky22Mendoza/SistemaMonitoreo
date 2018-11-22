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

	$(".kiosko").on('click', function(e) {
		e.preventDefault();
		$('#vistaAgencia').show();
		$('#vistaSeleccion').show();
	  $("#vistaKiosko").show();

	});

	$(".agencia").on('click', function(e) {
		e.preventDefault();
		$("#vistaSeleccion").show();
		$('#vistaAgencia').show();
		$('#vistaKiosko').show();

		var canvas = document.getElementById('kioscosServicio').getContext('2d');
		var canvas2 = document.getElementById('kioscosMantenimiento').getContext('2d');
		var canvas3 = document.getElementById('kioscoDesconectados').getContext('2d');
		var canvas4 = document.getElementById('alertasMes').getContext('2d');
		var canvas5 = document.getElementById('DisponibilidadKioscos').getContext('2d');

		var barChart = new Chart(canvas, {
		    type: 'pie',
		    data: {
					datasets :[{
						data : [
							10,
							2,
							3,
						], backgroundColor : [
							"#03F72C",
							"#FDFD00",
							"#FD0000",
						],
						labels : [
							"Servicio",
							"Mantenimiento",
							"Desconectado",
						]
					}]
				},
				options: {
            responsive: true, //True por defecto
        }
		});

		var barChart2 = new Chart(canvas2, {
		    type: 'pie',
		    data: {
					datasets :[{
						data : [
							10,
							2,
							3,
						], backgroundColor : [
							"#03F72C",
							"#FDFD00",
							"#FD0000",
						],
						labels : [
							"Servicio",
							"Mantenimiento",
							"Desconectado",
						]
					}]
				},
				options: {
            responsive: true, //True por defecto
        }
		});

		var barChart3 = new Chart(canvas3, {
		    type: 'pie',
		    data: {
					datasets :[{
						data : [
							10,
							2,
							3,
						], backgroundColor : [
							"#03F72C",
							"#FDFD00",
							"#FD0000",
						],
						labels : [
							"Servicio",
							"Mantenimiento",
							"Desconectado",
						]
					}]
				},
				options: {
            responsive: true, //True por defecto
        }
		});

		var barChart4 = new Chart(canvas4, {
		    type: 'bar',
		    data: {
					datasets :[{
						data : [
							10,
							2,
							3,
						], backgroundColor : [
							"#03F72C",
							"#FDFD00",
							"#FD0000",
						],
						labels : [
							"Servicio",
							"Mantenimiento",
							"Desconectado",
						]
					}]
				},
				options: {
            responsive: true, //True por defecto
        }
		});

		var barChart5 = new Chart(canvas5, {
		    type: 'line',
		    data: {
					datasets :[{
						data : [
							10,
							2,
							3,
						], backgroundColor : [
							"#03F72C",
							"#FDFD00",
							"#FD0000",
						],
						labels : [
							"Servicio",
							"Mantenimiento",
							"Desconectado",
						]
					}]
				},
				options: {
            responsive: true, //True por defecto
        }
		});

		window.pie = new Chart(canvas, barChart);
		window.pie = new Chart(canvas2, barChart2);
		window.pie = new Chart(canvas3, barChart3);
		window.pie = new Chart(canvas4, barChart4);
		window.pie = new Chart(canvas5, barChart5);

	});

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
