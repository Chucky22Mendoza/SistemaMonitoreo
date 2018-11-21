$(document).ready(function(){
  //$('#eliminarArchivos').hide();
  $('.cbAlerta').prop('checked',false);
  $('#cbAlerta').prop('checked',false);
  //SELECCIONAR TODOS LOS ROWS
  $('#cbAlerta').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbAlerta').prop('checked',true);
        $('#alertasUsuario').show();
    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
        $('.cbAlerta').prop('checked',false);
        $('#alertasUsuario').show();
    }
  });

  $('.cbAlerta').on('change', function(){
    var countSel = $('.cbAlerta:checked').get().length;
    if(countSel > 1){
      $('#alertasUsuario').show();
    }else{
      //$('#alertasUsuario').hide();
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
        $('#kioskoUsuario').show();
    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
        $('.cbKiosco').prop('checked',false);
        $('#kioskoUsuario').show();
    }
  });

  $('.cbKiosco').on('change', function(){
    var countSel = $('.cbKiosco:checked').get().length;
    if(countSel > 1){
      $('#kioskoUsuario').show();
    }else{
      //$('#alertasUsuario').hide();
    }

  });



  $('.ico-alertas').on('click',function(){

    var id = $(this).attr('id');
    var nombreUsuario = $(this).attr('name');

    $('#tituModal').replaceWith('<h5 id="tituModal">Kioscos asignados a '+nombreUsuario+'</h5>')

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



  $('.ico-kiosco').on('click',function(){

    var id = $(this).attr('id');
    var nombreUsuario = $(this).attr('name');

    $('#tituloModal').replaceWith('<h5 id="tituloModal">Alertas asignadas a '+nombreUsuario+'</h5>')

    $('#kioskoUsuario').modal('show');
    return false;
  });


  //Guardar los datos del Modal de kioscos asigandos al usuario
  $('#saveArchivo').on('click', function(){

  });
  //Finalizado del guadado de los datos que se insertaron en los modales del kiosko



  //Guardar los datos del Modal alertas asignadas a los KIOSCOS
  $('#guardarArchivo').on('click', function(){

  });
  //Finalizado del guardado del Modal de alertas asignadas a los Kioscos



  //Guardado de los datos del Modal Kioscos asignar alertas a los Usuarios

  //Finalizado del guardado del Modal de Kioscos Asignar Alertas a los Usuarios
});
