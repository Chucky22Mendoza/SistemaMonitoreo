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
			url:"kiosco.htm",
			data:datos,
			//MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
			beforeSend: function(){
				alertify.success('Cargando...');
			},
			error: function(error){
				//ERROR
				alertify.error("Error al cargar el Kiosco en cuestión");
			},
			success:function(r){
				//SE HA COMPLETADO

				$('#vistaAgencia').hide();
				$('#vistaSeleccion').hide();
				$('#vistaKiosko').replaceWith(r);
				$("#vistaKiosko").show();

			}
		});
		return false;
	});

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
				alertify.success('Cargando...');
			},
			error: function(error){
				//ERROR

				alertify.alert("Error al cargar la agencia en cuestión");
			},
			success:function(r){
				//SE HA COMPLETADO
				$("#vistaSeleccion").hide();
				$('#vistaKiosko').hide();
				$('#vistaAgencia').replaceWith(r);
				$('#vistaAgencia').show();

			}
		});
		return false;
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
