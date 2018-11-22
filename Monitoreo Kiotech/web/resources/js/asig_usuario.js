$(document).ready(function(){
  //$('#eliminarArchivos').hide();

  $('#cbAlerta').prop('checked',false);
  $('#cbUsuarios').prop('checked',false);
  $('#cbEventos').prop('checked',false);
  $('.cbUsuario').prop('checked',false);
  $('#cbEv').prop('checked',false);
  $('#cbEventos').on('change',function(){
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbEvento').prop('checked',true);
    } else {
        $('.cbEvento').prop('checked',false);
    }
  });

  $('#cbEv').on('change',function(){
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbAlertaSec2').prop('checked',true);
    } else {
        $('.cbAlertaSec2').prop('checked',false);
    }
  });

  $('#cbUsuarios').on('change',function(){
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbUsuario').prop('checked',true);
        $('#btnUsuariosEventos').show();
    } else {
      $('.cbUsuario').prop('checked',false);
      $('#btnUsuariosEventos').hide();
    }
  });
  //SELECCIONAR TODOS LOS ROWS
  $('#cbAlerta').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbAlertaSec').prop('checked',true);

    } else {
        $('.cbAlertaSec').prop('checked',false);
    }
  });

  $('.cbUsuario').on('change', function(){
    var countSel = $('.cbUsuario:checked').get().length;
    if(countSel > 1){
      $('#btnUsuariosEventos').show();
    }else{
      $('#btnUsuariosEventos').hide();
    }

  });

  $('#cbUser').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbUser').prop('checked',true);

    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
        $('.cbUser').prop('checked',false);

    }
  });


  //$('#eliminarArchivos').hide();
  $('.cbKiosco').prop('checked',false);
  $('#cbKiosco').prop('checked',false);
  //SELECCIONAR TODOS LOS ROWS
  $('#cbKiosco').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbKiosco').prop('checked',true);

    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
        $('.cbKiosco').prop('checked',false);

    }
  });

  $('.ico-kiosco').on('click',function(){

    var id = $(this).attr('id');
    var nombreUsuario = $(this).attr('name');
    $('#usuarioHidden2').val(id);
    $('#tituloModal').replaceWith('<h5 id="tituloModal" name ="'+id+'">Alertas asignadas a '+nombreUsuario+'</h5>');

    var datos = {
      id_usuario : id
    };
    //console.log(datos);
    $.ajax({
      type:"POST",
      url:"asig_eventos.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        //alertify.success('Cargando...');
      },
      //ERROR
      error: function(error){

      },
      //SE HA COMPLETADO
      success:function(r){
        $('#rows2').replaceWith(r);
      }
    });
    $('#kioscoUsuario').modal('show');
    return false;
  });

  $('.ico-alertas').on('click',function(){

    var id = $(this).attr('id');
    var nombreUsuario = $(this).attr('name');
    $('#usuarioHidden').val(id);
    $('#tituModal').replaceWith('<h5 id="tituModal" name = "'+id+'">Kioscos asignados a '+nombreUsuario+'</h5>')

    var datos = {
      id_usuario : id
    };
    //console.log(datos);
    $.ajax({
      type:"POST",
      url:"usuario_kioscos.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        //alertify.success('Cargando...');
      },
      //ERROR
      error: function(error){

      },
      //SE HA COMPLETADO
      success:function(r){
        $('#rows').replaceWith(r);
      }
    });
    $('#alertasUsuario').modal('show');
    return false;
  });

  //Guardar los datos del Modal de kioscos asigandos al usuario
  $('#btnEventos').on('click', function(){
    borrarAsigEventos();
    var countSel = $('.cbAlertaSec2:checked').get().length;
    var alerta = $('.cbAlertaSec2:checked').get();
    var id_usuario = $('#usuarioHidden2').val();
    if(countSel > 0){
      for (var i = 0; i < countSel; i++) {
        var idE = alerta[i].id;
        registrarEvento(true,true,idE,id_usuario);
      }
    }
    alertify.success("Guardado correctamente");
    setTimeout(function(){
      window.location.assign("asignar_usuario.htm");
    }, 2000);
  });
  //Finalizado del guadado de los datos que se insertaron en los modales del kiosko


});


//Guardar los datos del Modal alertas asignadas a los KIOSCOS
$('#guardarArchivo').on('click', function(){

  borrarAsig();
  var countSel = $('.cbAlertaSec:checked').get().length;
  var alerta = $('.cbAlertaSec:checked').get();

  if(countSel > 0){
    for (var i = 0; i < countSel; i++) {
      var idK = alerta[i].id;
      var idU = alerta[i].name;
      registrarAsig(idK,idU);
    }

  }
  alertify.success("Guardado correctamente");
  setTimeout(function(){
    window.location.assign("asignar_usuario.htm");
  }, 2000);
});
//Finalizado del guardado del Modal de alertas asignadas a los Kioscos

$('#btnUsuariosEventos').on('click',function(){
  var countSel = $('.cbUsuario:checked').get().length;
  var usuario = $('.cbUsuario:checked').get();
  $('tr').remove('.tr');

  $('#selUs').html('Usuarios seleccionados ('+countSel+')');
  for (var i = 0; i < countSel ; i++) {
    var id = usuario[i].id;
    var nombre = usuario[i].name;
    $('#usBody').before('<tr class="tr">'
    + '<td class="text-center"><input id="'+id+'" type="checkbox" class="mt-1 cbUser" name="'+nombre+'"></td>'
    +'<td class="text-center">'+nombre+'</td>'
    +'</tr>');
  }

});

$('#btnMultiEventos').on('click',function(){
  var countSel = $('.cbUser:checked').get().length;
  var usuario = $('.cbUser:checked').get();
  var countSel2 = $('.cbEvento:checked').get().length;
  var evento = $('.cbEvento:checked').get();
  var cbSMS = $('#cbMensaje').is(':checked');
  var cbCorreo = $('#cbCorreo').is(':checked');
  var count = 0;
  if(countSel > 0){
    if(countSel2 > 0){
      if(cbSMS || cbCorreo){

        for (var i = 0; i < countSel; i++) {
          var id_usuario = usuario[i].id;
          borrarEventosUsuario(id_usuario);

          for (var j = 0; j < countSel2; j++) {
            var id_evento = evento[j].id;
            registrarEvento(cbSMS,cbCorreo,id_evento,id_usuario);

          };
        };
      }else{
        alertify.error('Favor de seleccionar un medio de envío');
        return false;
      }
    }else{
      alertify.error('Favor de seleccionar al menos un evento');
      return false;
    }
  }else{
    alertify.error('Favor de seleccionar al menos un usuario');
    return false;
  }
  alertify.success("Guardado correctamente");
  setTimeout(function(){
    window.location.assign("asignar_usuario.htm");
  }, 1200);
});


function borrarEventosUsuario(id_usuario){
  var data = {
    id_usuario : id_usuario
  };

  $.ajax({
    type:"POST",
    url:"borrar_eventos.htm",
    data:data,
    //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
    beforeSend: function(){
      //alertify.success('Cargando...');
    },
    //ERROR
    error: function(error){
      //alertify.alert("Error en la transacción");
    },
    //SE HA COMPLETADO
    success:function(r){

    }
  });
}

function borrarAsig(){
  var valor = $('#usuarioHidden').val();

  var data = {
    id_usuario : valor
  };

  $.ajax({
    type:"POST",
    url:"borrar_asignados.htm",
    data:data,
    //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
    beforeSend: function(){
      //alertify.success('Cargando...');
    },
    //ERROR
    error: function(error){
      //alertify.alert("Error en la transacción");
    },
    //SE HA COMPLETADO
    success:function(r){

    }
  });

}

function registrarAsig(idK,idU){
  var datos = {
    id_kiosco : idK,
    id_usuario : idU
  };
  $.ajax({
    type:"POST",
    url:"ingresar_kioscos.htm",
    data:datos,
    //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
    beforeSend: function(){

    },
    //ERROR
    error: function(error){
      //alertify.error("Error en la transacción");
    },
    //SE HA COMPLETADO
    success:function(r){

    }
  });
}

function borrarAsigEventos(){
  var valor = $('#usuarioHidden2').val();

  var data = {
    id_usuario : valor
  };

  $.ajax({
    type:"POST",
    url:"borrar_eventos.htm",
    data:data,
    //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
    beforeSend: function(){
      //alertify.success('Cargando...');
    },
    //ERROR
    error: function(error){
      //alertify.alert("Error en la transacción");
    },
    //SE HA COMPLETADO
    success:function(r){

    }
  });
}

function registrarEvento(sms,correo,idE,idU){
  var datos = {
    sms : sms,
    correo : correo,
    id_evento : idE,
    id_usuario : idU
  };
  $.ajax({
    type:"POST",
    url:"ingresar_eventos.htm",
    data:datos,
    //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
    beforeSend: function(){

    },
    //ERROR
    error: function(error){
      //alertify.error("Error en la transacción");
    },
    //SE HA COMPLETADO
    success:function(r){

    }
  });
}
