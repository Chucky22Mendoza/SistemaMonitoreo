$(document).ready(function(){
	
	primero();
	
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
