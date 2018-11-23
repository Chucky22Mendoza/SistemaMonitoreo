$(document).ready(function(){

	//primero();
	$('#cbGenKiosco').on('change',function(){
		var cb = $(this).is(':checked');
		if(cb){
			$('.cbKio').prop('checked',true);

		}else{

			$('.cbKio').prop('checked',false);

		}

		checks();
	});
	checks();


	$('.select').on('click', function(){
		$('#rightSection').show();
		var idKiosco = $(this).attr('id');
		var nombre = $(this).attr('name');

		$('#idKioH').val(idKiosco);
		//alert(nombre);
		$('#kioscoListas').html('Listas de reproducción programadas de ' + nombre);
		var data = {id : idKiosco};
		$.ajax({
            url:"ver_listas.htm",
            type: 'POST',
            data: data,
            beforeSend: function(data){
              //alert('antes');
            },
            success: function(data){
				//console.log(data);
				$('#rows').replaceWith(data);
            },//ERROR
            error: function(data){
              //console.log('error');
           }

        });

	});

	$('.cbKio').on('change', function() {
		checks();
	});

	$('#btnMultList').on('click', function(){


		var countSel = $('.cbKio:checked').get().length;
		var kioscos = $('.cbKio:checked').get();

		$('tr').remove('.tr');


		for (var i = 0; i < countSel; i++) {
			var kio = kioscos[i].value;
			kio = kio.toString();//CONVERTIMOS EN CADENA
		  var str = kio.split("-");//SEPARAMOS POR "-" PARA OBTENER CADA VALOR
		  var id = str[0];//ID
		  var nombre = str[1];//nombre
		  id = parseInt(id);
			//console.log(id);
			$('#kioscos').before('<tr class="tr"><td id="'+id+'" value="'+id+'" name="'+nombre+'" class="text-center">'+nombre+'</td>'
			+'<input class="selKio" type="hidden" value="'+id+'">'+'</tr>');
		}
		$('#modalMultProgramacion').modal('show');
	});



});

$('#btnMultListKio').on('click', function(){
	var countKio = $('.selKio').get().length;
	var kioscos = $('.selKio').get();
	//console.log(countKio);
	for (var i = 0; i < countKio; i++) {
		var idKiosco = kioscos[i].value;
		var countCk = 0;
		var horaInicial = $('#horaInicial1').val();
		var intHI = horaInicial.length;

		var domingo = $('#domingo').is(':checked');
		if(domingo){countCk++;}

		var lunes = $('#lunes').is(':checked');
		if(lunes){countCk++;}

		var martes = $('#martes').is(':checked');
		if(martes){countCk++;}

		var miercoles = $('#miercoles').is(':checked');
		if(miercoles){countCk++;}

		var jueves = $('#jueves').is(':checked');
		if(jueves){countCk++;}

		var viernes = $('#viernes').is(':checked');
		if(viernes){countCk++;}

		var sabado = $('#sabado').is(':checked');
		if(sabado){countCk++;}

		var idLista = $('#selectMultList').val();
		//var idKiosco = $('#idKioH').val();
		//console.log(idKiosco);
		if(countCk > 0){
			if(intHI > 0){
				var datos = {
					horaInicial : horaInicial,
					domingo : domingo,
					lunes : lunes,
					martes : martes,
					miercoles : miercoles,
					jueves : jueves,
					viernes : viernes,
					sabado : sabado,
					idKiosco : idKiosco,
					idLista : idLista
				};
				//console.log(datos);
        $.ajax({
					type:"POST",
		      url:"programar_lista.htm",
		      data:datos,
		      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
		      beforeSend: function(){
						alertify.success('Cargando...');
		        //showSpinner();
		      },
		      //ERROR
		      error: function(error){

		        alertify.alert("Error en la transacción");
		      },
			    success: function(data){
					 if(data == 1){

					  	alertify.error("Ha ocurrido un error");
					 }
		     }
				});

				//return false;
			}else{
				alertify.error("Favor de ingresar la hora de inicio");
			}

		}else{
			alertify.error("Favor de señalar al menos un día para reproduccir la lista");
		}
	}

	alertify.success("Guardado correctamente");
	setTimeout(function(){
			//Update tabla en lugar de refresh y cerrar modal
			window.location.assign("programacion.htm");
	}, 1200);
});

$('#addPL').on('click', function(){
	$('#selectList').removeAttr('disabled');
	$('#selTipo').val(0);


});

$('#btnProgramarLista').on('click', function(){
	var tipo = $('#selTipo').val();
	if(tipo == 0){
		var countCk = 0;
		var horaInicial = $('#horaInicial').val();
		var intHI = horaInicial.length;

		var domingo = $('#domingo1').is(':checked');
		if(domingo){countCk++;}

		var lunes = $('#lunes1').is(':checked');
		if(lunes){countCk++;}

		var martes = $('#martes1').is(':checked');
		if(martes){countCk++;}

		var miercoles = $('#miercoles1').is(':checked');
		if(miercoles){countCk++;}

		var jueves = $('#jueves1').is(':checked');
		if(jueves){countCk++;}

		var viernes = $('#viernes1').is(':checked');
		if(viernes){countCk++;}

		var sabado = $('#sabado1').is(':checked');
		if(sabado){countCk++;}

		var idLista = $('#selectList').val();
		var idKiosco = $('#idKioH').val();

		if(countCk > 0){
			if(intHI > 0){
				var datos = {
					horaInicial : horaInicial,
					domingo : domingo,
					lunes : lunes,
					martes : martes,
					miercoles : miercoles,
					jueves : jueves,
					viernes : viernes,
					sabado : sabado,
					idKiosco : idKiosco,
					idLista : idLista
				};
				//console.log(datos);
        $.ajax({
					type:"POST",
		      url:"programar_lista.htm",
		      data:datos,
		      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
		      beforeSend: function(){
						alertify.success('Cargando...');

		      },
		      //ERROR
		      error: function(error){

		        alertify.alert("Error en la transacción");
		      },
			    success: function(data){
					 if(data == 1){

					  	alertify.error("Ha ocurrido un error");
					 }else{
							alertify.success("Guardado correctamente");
							setTimeout(function(){
					        //Update tabla en lugar de refresh y cerrar modal
					        window.location.assign("programacion.htm");
					    }, 1200);
					 }
		     }
				});

				return false;
			}else{
				alertify.error("Favor de ingresar la hora de inicio");
			}

		}else{
			alertify.error("Favor de señalar al menos un día para reproduccir la lista");
		}


	}else{
		var countCk = 0;
		var horaInicial = $('#horaInicial').val();
		var intHI = horaInicial.length;

		var domingo = $('#domingo1').is(':checked');
		if(domingo){countCk++;}

		var lunes = $('#lunes1').is(':checked');
		if(lunes){countCk++;}

		var martes = $('#martes1').is(':checked');
		if(martes){countCk++;}

		var miercoles = $('#miercoles1').is(':checked');
		if(miercoles){countCk++;}

		var jueves = $('#jueves1').is(':checked');
		if(jueves){countCk++;}

		var viernes = $('#viernes1').is(':checked');
		if(viernes){countCk++;}

		var sabado = $('#sabado1').is(':checked');
		if(sabado){countCk++;}

		var idLista = $('#selectList').val();
		var idKiosco = $('#idKioH').val();

		if(countCk > 0){
			if(intHI > 0){
				var datos = {
					horaInicial : horaInicial,
					domingo : domingo,
					lunes : lunes,
					martes : martes,
					miercoles : miercoles,
					jueves : jueves,
					viernes : viernes,
					sabado : sabado,
					idKiosco : idKiosco,
					idLista : idLista
				};
				//console.log(datos);
        $.ajax({
					type:"POST",
		      url:"actualizar_programar_lista.htm",
		      data:datos,
		      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
		      beforeSend: function(){
						//console.log('enviando...');
		        alertify.success('Cargando...');
		      },
		      //ERROR
		      error: function(error){

		        alertify.alert("Error en la transacción");
		      },
			    success: function(data){
					 if(data == 1){
					  	alertify.error("Ha ocurrido un error");
					 }else{
							alertify.success("Guardado correctamente");
							setTimeout(function(){
					        //Update tabla en lugar de refresh y cerrar modal
					        window.location.assign("programacion.htm");
					    }, 1200);
					 }
		     }
				});

				return false;
			}else{
				alertify.error("Favor de ingresar la hora de inicio");
			}

		}else{
			alertify.error("Favor de señalar al menos un día para reproduccir la lista");
		}
	}
});

function primero(){
	var idKiosco = $('.primero').attr('id');
	var nombre = $('.primero').attr('name');
	//alert(nombre);
	$('#kioscoListas').html('Listas de reproducción programadas de ' + nombre);
	var data = {id : idKiosco};
	$.ajax({
        url:"ver_listas.htm",
        type: 'POST',
        data: data,
        beforeSend: function(data){
          //alert('antes');
        },
        success: function(data){
			//console.log(data);
			$('#rows').replaceWith(data);
        },//ERROR
        error: function(data){
          //console.log('error');
       }
	});
}

function checks(){
	var countSel = $('.cbKio:checked').get().length;
	if(countSel > 1){
		$('#rightSection').hide();
		$('#MultSection').show();
		$('#textMultKio').html(countSel + ' kioscos seleccionados');
	}else{
		if(countSel == 1){
			$('#rightSection').show();
			$('#MultSection').hide();
		}
	}
}
