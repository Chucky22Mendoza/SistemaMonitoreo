$(document).ready(function(){

	$('#tableHA').DataTable();

});

$('.ico-detalles').on('click', function(){
			var id = $(this).attr('id');
			var valor = $(this).attr('value'); //VALORES DEL ROW
			valor = valor.toString();//CONVERTIMOS EN CADENA
			var str = valor.split("/");//SEPARAMOS POR "/" PARA OBTENER CADA VALOR
			var fechaHora = str[0];//fechaHora
			var tipoAlerta = str[1];//tipoAlerta
			var mensaje = str[2];//mensaje
			var kiosco = str[3];//kiosco
			alert("--ID: " + id + " --FECHA Y HORA: " + fechaHora + " --TIPO DE ALERTA: " + tipoAlerta + " --MENSAJE: " + mensaje + " --KIOSCO: " + kiosco);
	});

$('.ico-status').on('click', function(){
	var status = $(this).attr('name');
	var id_alert = $(this).attr('id');
	var kiosco = $(this).attr('value');
	//console.log(kiosco);
	//console.log(id_alert);
	if(status == 'true'){
		alertify.confirm("¿Desea cambiar el status de esta alerta sin atender?",
		function(){
			cambiar_status(false,id_alert);
		},
		function(){
			alertify.error('Cancelado');
		});
	}else{
		alertify.confirm("¿La alerta ha sido atendida?",
		function(){
			cambiar_status(true,id_alert);
		},
		function(){
			alertify.error('Cancelado');
		});
	}
});

function cambiar_status(status,id_alert){
	datos = {
		status : status,
		id_historial_alerta : id_alert
	}

	$.ajax({
		url:"cambiar_status.htm",
		type: 'POST',
		data: datos,
		beforeSend: function(data){
			//$('#tableHA').DataTable();
		  //$('#rows').replaceWith('<h1 id="rows" class="text-center">Cargando información<h1>')
			//alertify.success('Cargando...');
		},
		success: function(data){
			if(data != 0){
				//$('#rows').replaceWith(data);
				alertify.success('Guardado correctamente')
				setTimeout(function(){
						//Update tabla en lugar de refresh y cerrar modal
						window.location.assign("historial.htm");
				}, 1200);
			}else{
				alertify.error('No se realizó el cambio de status');
			}

		},//ERROR
		error: function(data){
			alertify.error('Error en la transacción');
		}
	});

}
