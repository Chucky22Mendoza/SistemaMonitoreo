$(document).ready(function(){
	$('#cbGenOrden').prop('checked',false);
	$('.cbSelectOrden').prop('checked',false);
	$('#btnEliminar').hide();

	$('.takeRow').on('click',function(){
        if($(this).hasClass('activado')){
            $(this).removeClass('activado');
        }else{
            $('.takeRow').removeClass('activado');
            $(this).addClass('activado');
        }
		orden = $(this).children('.orden').attr("name");
		orden = parseInt(orden);

    });

	$('#up').click(function(){
		if(orden != 0){
		    var anterior = $('.activado').prev();
		    var actual = $('.activado');
			//obtener orden
			var ordenAnt = anterior.children('.orden').attr("name");
			var ordenAct = actual.children('.orden').attr("name");

			//no mover el orden
			anterior.children('.orden').html(ordenAct);
			actual.children('.orden').html(ordenAnt);

			//cambiar el orden
			anterior.children('.orden').attr("name",ordenAct);
			actual.children('.orden').attr("name",ordenAnt);

		    $(anterior).insertAfter(actual);
	    }else{
			alert('seleccione una fila');
		}

	});

	$('#down').click(function(){
		if(orden != 0){
		    var siguiente = $('.activado').next();
		    var actual = $('.activado');
			//obtener orden
			var ordenSig = siguiente.children('.orden').attr("name");
			var ordenAct = actual.children('.orden').attr("name");
			//console.log(ordenAct + " - " + ordenSig);

			siguiente.children('.orden').html(ordenAct);
			actual.children('.orden').html(ordenSig);

			siguiente.children('.orden').attr("name",ordenAct);
			actual.children('.orden').attr("name",ordenSig);

		    $(siguiente).insertBefore(actual);

		}else{
			alert('seleccione una fila');
		}
	});


});
