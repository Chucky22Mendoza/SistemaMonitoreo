$(document).ready(function(){
  $('#btnGuardarConfigSMTP').on('click',function(){
    var server_smtp = $('#servidor_smtp').val();
    var user = $('#usuario').val();
    var pass = $('#password').val();
    var port = $('#puerto').val();
    var segurity = $('#seguridad').val();

    if(segurity == 'SSL'){
      alertify.error('Para poder enviar un correo por seguridad SSL debe de configurarse las credenciales de tu correo');
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
        alertify.error('Error al intentar guardar la configuración');
        return false;
      },
      //SE HA COMPLETADO
      success:function(r){
        $('#spinnerConfServer').hide();
        if(r == 1){
          alertify.success('La configuración se ha guardado correctamente');
        }else{
          alertify.error('Error al intentar guardar la configuración');
        }

      }
    });
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
  });
});
