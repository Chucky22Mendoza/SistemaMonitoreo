$(document).ready(function(){

	primero();
	checks();

	$('.select').on('click', function(){
		var idKiosco = $(this).attr('id');
		var nombre = $(this).attr('name');
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
              console.log('error');
           }

        });

	});

	$('.cbKio').on('change', function() {
		checks();
	});

	$('#btnMultList').on('click', function(){


		var countSel = $('.cbKio:checked').get().length;
		var kioscos = $('.cbKio:checked').get();
<<<<<<< HEAD
		$('tr').remove('.tr');
=======
>>>>>>> parent of e0c8911... NAN

		for (var i = 0; i < countSel; i++) {
			var kio = kioscos[i].value;
			//kio = kio.toString();//CONVERTIMOS EN CADENA
		  //var str = kio.split("-");//SEPARAMOS POR "-" PARA OBTENER CADA VALOR
		  //var id = str[0];//ID
		  //var nombre = str[1];//TIPO
		  //id = parseInt(id);
			//console.log(id + " - " + nombre);
			console.log(kio);
		}
		$('#modalMultProgramacion').modal('show');
	});


});

$('.ico-edit').on('click', function(){
	//$('#selectList').attr('disabled','disabled');
	//$('#modalProgramarLista').modal('show');
	alert(1);
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
          console.log('error');
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
