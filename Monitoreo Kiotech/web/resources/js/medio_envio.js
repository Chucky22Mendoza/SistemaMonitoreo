$(document).ready(function(){
  $('#btnGuardarConfigSMTP').on('click',function(){
    
    var server_smtp = $('#servidor_smtp').val();
    var user = $('#usuario').val();
    var pass = $('#password').val();
    var port = $('#puerto').val();
    var segurity = $('#seguridad').val();

    if(segurity == 'SSL'){
      alertify.error('Este es el link donde debe activarse para el envio de correos, si se tiene activada la verificación en dos pasos <strong>NO ES POSIBLE ENVIAR CORREOS SSL:<strong> <a href="https://myaccount.google.com/u/2/lesssecureapps?pageId=none">click aquí!!!</a>');
    }

    var datos = {
      servidor_smtp : server_smtp,
      usuario : user,
      contrasena : pass,
      puerto : port,
      seguridad : segurity
    }

    //console.log(datos);

    $.ajax({
      type:"POST",
      url:"servidor_smtp.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        $('#spinnerConfServer').show();
      },
      //ERROR
      error: function(error){
        $('#spinnerConfServer').hide();
        alertify.error('<strong>NO ES POSIBLE ENVIAR CORREOS SSL:</strong> <a href="https://myaccount.google.com/u/2/lesssecureapps?pageId=none">click aquí!!!</a>');
        return false;
      },
      //SE HA COMPLETADO
      success:function(r){
        $('#spinnerConfServer').hide();
        //if(r == 1){
          alertify.success('La configuración se ha guardado correctamente');
        //}else{
          //alertify.error('Error al intentar guardar la configuración');
        //}

      }
    });
    return false;
  });

  $('#btnProbarCorreo').on('click', function(){
    var mensaje = $('#mensaje').val();
    var correo = $('#correo').val();

    var datos = {
      mensaje : mensaje,
      correo : correo
    }

    //console.log(datos);

    $.ajax({
      type:"POST",
      url:"enviar_correo.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        $('#spinnerEnviandoCorreo').show();
      },
      //ERROR
      error: function(error){
        $('#spinnerEnviandoCorreo').hide();
        alertify.error('Se necesita configurar el correo para enviar por seguridad SSL');
        return false;
      },
      //SE HA COMPLETADO
      success:function(r){
        $('#spinnerEnviandoCorreo').hide();
        //if(r == 1){
          alertify.success('El correo se ha enviado correctamente');
        //}else{
          //alertify.error('Error al intentar enviar el correo');
        //}
      }
    });
    return false;
  });

  $('#btnGuardarPuerto').on('click',function(){

    var port = $('#puertos').val();

    var datos = {
      puerto : port
    }

    //console.log(datos);

    $.ajax({
      type:"POST",
      url:"puerto_tarjeta_sms.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        $('#spinnerConfPorts').show();
      },
      //ERROR
      error: function(error){
        $('#spinnerConfPorts').hide();
        alertify.error('Error al intentar guardar la configuración');
        return false;
      },
      //SE HA COMPLETADO
      success:function(r){
        $('#spinnerConfPorts').hide();
          alertify.success('La configuración se ha guardado correctamente');
      }
    });
    return false;
  });

  $('#btnEnviarSMS').on('click',function(){

    var mensaje = $('#mensaje').val();
    var celular = $('#celular').val();

    var datos = {
      mensaje : mensaje,
      celular : celular
    }

    //console.log(datos);

    $.ajax({
      type:"POST",
      url:"enviar_sms.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        $('#spinnerEnviarSMS').show();
      },
      //ERROR
      error: function(error){
        $('#spinnerEnviarSMS').hide();
        alertify.error('Error al intentar enviar el mensaje sms');
        return false;
      },
      //SE HA COMPLETADO
      success:function(r){
        $('#spinnerEnviarSMS').hide();
          alertify.success('El mensaje ha sido enviado con éxito');
      }
    });
    return false;
  });
});
