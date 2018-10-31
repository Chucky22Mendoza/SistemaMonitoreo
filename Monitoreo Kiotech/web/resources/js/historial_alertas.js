$(document).ready(function(){
	
	$('#tableHA').DataTable();
  
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
	
  

});
