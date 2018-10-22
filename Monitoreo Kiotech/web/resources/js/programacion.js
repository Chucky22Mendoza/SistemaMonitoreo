$(document).ready(function(){
  var nameAgencia = $('#1').attr('name');

  nameAgencia = nameAgencia.toString();//CONVERTIMOS EN CADENA
  var str = nameAgencia.split("-");//SEPARAMOS POR "-" PARA OBTENER CADA VALOR
  var nombre = str[0];//NOMBRE
  var agencia = str[1];//TIPO
  $('#kioscoListas').html('Listas de reproducción programadas de ' + nombre);

  $('.sel').on('click', function(){
    var name = $(this).attr('name');
    name = name.toString();//CONVERTIMOS EN CADENA
    var str = name.split("-");//SEPARAMOS POR "-" PARA OBTENER CADA VALOR
    var nombre = str[0];//NOMBRE


    $('#kioscoListas').html('Listas de reproducción programadas de ' + nombre);
    $('#nombreLista').html('Lista de reproduccion 2');
    $('#horaInicio').html('12:30:00 hrs');
    $('#D').prop('checked',true);
    $('#Ma').prop('checked',true);
    $('#Mi').prop('checked',true);
    $('#S').prop('checked',true);
  });

});
