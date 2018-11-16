$(document).ready(function(){
  //$('#modalEditarArchivos').modal('show');
  //$('#modalAgregarArchivos').modal('show');
  //SELECCIONAR TODOS LOS ROWS
  $('#cbGen').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbSelec').prop('checked',true);
    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
    }
  });

});

//EVENTO DEL ICONO DE EDITAR EN EL ARCHIVO
$('.ico-editList').on('click', function(){
  //PRIMERO SE BORRAN LOS DIVS POR SI HAY RECIDUOS DE OTRO MODAL
  $('#titleNameList').remove();
  $('#bodyEditList').remove();

  //OBTENEMOS LOS PARAMETROS
  var id = $(this).attr('id');//ID DEL ROW
  id = parseInt(id); //CONVERTIR A INTEGER
  var valor = $(this).attr('value'); //VALORES DEL ROW (NOMBRE, TIPO, DURACION)
  valor = valor.toString();//CONVERTIMOS EN CADENA
  var str = valor.split("-");//SEPARAMOS POR "-" PARA OBTENER CADA VALOR
  var nombre = str[0];//NOMBRE
  var descripcion = str[1];//DESCRIPCION

  //SE ESCRIBE EL CONTENIDO DEL MODAL, JUNTO CON LOS INPUTS, LABELS, ETC
  $('#titleModalList').append('<h5 class="modal-title" id="titleNameList">Editar '+ nombre +'</h5> ');
  $('#modal-bodyList').append('<div id="bodyEditList">'
  //INPUT HIDDEN CON EL VALOR DEL ID
     +'<input type="hidden" id="idList" name="idList" value="'+id+'" />'
     + '<div class="col-sm-12 row d-flex justify-content-center align-items-center mt-3">'
          +'<label for="nombreList" class="col-sm-3 form-control-label mr-2">Nombre:</label>'
          +'<input class="form-control col-sm-8" id="nombreList" placeholder="Cambiar nombre de la lista de reproducción" type="text" name="nombreList" required="required">'
       +'</div>'
       + '<div class="col-sm-12 row d-flex justify-content-center align-items-center mt-3">'
          +'<label for="descripcion" class="col-sm-3 form-control-label">Descripción:</label>'
          +'<input class="form-control col-sm-8" id="descripcion" placeholder="Cambiar descripcion" type="text" name="descripcion" required="required">'
       +'</div>'
  + '</div>');

  //LES DAMOS VALORES A LOS INPUTS PARA FACILITAR AL USUARIO
  $('#nombreList').val(nombre);
  $('#descripcion').val(descripcion);

  $('#modalEditarLista').modal('show');//ABRIMOS EL MODAL

});

//EVENTO DEL ICONO DE BORRAR EN EL ARCHIVO
$('.ico-delList').on('click', function(){
  //PRIMERO SE BORRAN LOS DIVS POR SI HAY RECIDUOS DE OTRO MODAL
  $('#titleNameDelList').remove();
  $('#bodyDelList').remove();

  //OBTENEMOS LAS VARIABLES DEL ROW
  var id = $(this).attr('id');
  var name = $(this).attr('name');

  //ABRIMOS EL MODAL
  $('#modalBorrarLista').modal('show');
  //SE ESCRIBE EL CONTENIDO DEL MODAL
  $('#titleModalDelList').append('<h5 class="modal-title" id="titleNameDelList">Borrar '+ name +'</h5> ');
  $('#modal-bodyDelList').append('<div id="bodyDelList">'
  + '<h2 class="text-center">¿Estás seguro de borrar la lista "' + name + '"?</h2>'
  + '</div>');
  //INPUT HIDDEN CON EL VALOR DEL ID (EL QUE SERÁ ENVIADO POR AJAX)
  $('#DelList').append('<input type="hidden" id="idList" name="idList" value="'+id+'" />')

});

//EVENTO DEL ICONO DE BORRAR EN EL ARCHIVO
$('.ico-program').on('click', function(){
  //PRIMERO SE BORRAN LOS DIVS POR SI HAY RECIDUOS DE OTRO MODAL
  $('#titleNameEditFiles').remove();

  //OBTENEMOS LAS VARIABLES DEL ROW
  var name = $(this).attr('name');

  //ABRIMOS EL MODAL
  //$('#modalEditarArchivos').modal('show');
  //SE ESCRIBE EL CONTENIDO DEL MODAL
  $('#titleModalEditFiles').append('<h5 class="modal-title" id="titleNameEditFiles">Editar archivos de '+ name +'</h5> ');

});

//AJAX PARA PROCESAR AL EDITAR UN ARCHIVO
  $('#updateList').click(function(){
    //VARIABLE DEL FORMULARIO
    var datos = $('#EditList').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var idList = $('#idList').val();
    var nombreList = $('#nombreList').val();
    var descripcion = $('#descripcion').val();

    //console.log(datos);
    //ABRIMOS AJAX
    $.ajax({
      type:"POST",
      url:"Edit_List.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        //showSpinner();
      },
      error: function(error){
        //ERROR
        removeSpinner();
        alertify.alert("Error en la transacción");
      },
      success:function(r){
        //SE HA COMPLETADO
        //showSpinner();
        $('#modalEditarLista').modal('hide');
        alertify.success("Guardado correctamente");
        //TIEMPO DE ESPERA DEL AVISO
        setTimeout(function(){

          //Update tabla en lugar de refresh y cerrar modal
          window.location.assign("listas.htm");
        }, 1200);

      }
    });
    return false;
  });

//AJAX PARA PROCESAR AL GUARDAR UN NUEVO ARCHIVO
  $('#nuevaLista').click(function(){
    //VARIABLE DEL FORMULARIO
    var datos = $('#NewList').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var nombreList = $('#nombreList').val();
    var duracion = $('#descripcion').val();

    //ABRIMOS AJAX
    $.ajax({
      type:"POST",
      url:"New_List.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        showSpinner();
      },
      //ERROR
      error: function(error){
        removeSpinner();
        alertify.alert("Error en la transacción");
      },
      //SE HA COMPLETADO
      success:function(r){
        showSpinner();
        alertify.success("Guardado correctamente");
        //TIEMPO DE ESPERA DEL AVISO
        setTimeout(function(){
          //Update tabla en lugar de refresh y cerrar modal
          //window.location.assign("listas.htm");
          var nombrelista = $('#nombreList').val();
          $('#titleModalNewsFiles').html('Agregar archivos a ' + nombrelista);
          $('#modalAgregarArchivos').modal('show');
        }, 1200);
      }
    });
    return false;
  });

  $('#nuevosArchivos').on('click',function(){
    var countSel = $('.cbAr:checked').get().length;
    var idLista = $('#ultimoID').val();
    var archivos = $('.cbAr:checked').get();
    //console.log("ID Lista: "+ idLista);
    //console.log("Celdas: "+ countSel);

    if(countSel > 0){

      for (var i = 0; i < countSel; i++) {
        var arch = archivos[i].value;
        var orden = i+1;
        //console.log(arch);
        var datos = {
          idLista : idLista,
          idArchivo : arch,
          orden : orden
        };

        $.ajax({
          type:"POST",
          url:"NewsFiles.htm",
          data:datos,
          //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
          beforeSend: function(){
            showSpinner();
          },
          //ERROR
          error: function(error){
            removeSpinner();
            alertify.alert("Error en la transacción");
          },
          //SE HA COMPLETADO
          success:function(r){
            showSpinner();

          }
        });
        //return false;
      }
      alertify.success("Guardado correctamente");
      //TIEMPO DE ESPERA DEL AVISO
      setTimeout(function(){
        window.location.assign("listas.htm");
      }, 1200);
    }else{
      alertify.error("Favor de seleccionar al menos un archivo");
    }

  });

//AJAX PARA PROCESAR EL BORRADO DE UN ARCHIVO
  $('#borrarLista').click(function(){

    //VARIABLE DEL FORMULARIO
    var datos = $('#DelList').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var idList = $('#idList').val();
    idList = parseInt(idList);

    //ABRIMOS AJAX
    $.ajax({
      type:"POST",
      url:"Delete_List.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        showSpinner();
      },
      //ERROR
      error: function(error){
        removeSpinner();
        alertify.alert("Error en la transacción");
      },
      //SE HA COMPLETADO
      success:function(r){
        showSpinner();
        alertify.success("Borrado correctamente");
        //TIEMPO DE ESPERA DEL AVISO
        setTimeout(function(){
          //Update tabla en lugar de refresh y cerrar modal
          window.location.assign("listas.htm");
        }, 1200);
      }
    });
    return false;
  });


  $('.ico-program').on('click',function(){
    var id = $(this).attr('id');
    $('#idLista_archivo').val(id);
		var datos = {idLista : id};

		$.ajax({
        url:"edit_files.htm",
        type: 'POST',
        data: datos,
        beforeSend: function(data){
          //alert('antes');
        },
        success: function(data){
            //var val = document.getElementById('exTitle').value;
            //console.log(data);
            if(data == 1){
              $('#modalNoResultados').modal('show');
              //$('#modalEditarArchivos').modal('hide');
            }else{
              $('#rows').replaceWith(data);
              $('#modalEditarArchivos').modal('show');
            }
        },//ERROR
        error: function(data){
          console.log(data);
        }
    });
  });

  $('#btnAddFiles').on('click',function(){
    $('#modalEditarArchivos').modal('hide');
    var id = $('#idLista_archivo').val();
    //console.log(id);
		var datos = {idLista : id};

		$.ajax({
        url:"ver_dif.htm",
        type: 'POST',
        data: datos,
        beforeSend: function(data){
          //alert('antes');
        },
        success: function(data){

            $('#rows2').replaceWith(data);
            //$('#modalEditarArchivos').modal('show');

        },//ERROR
        error: function(data){
          console.log(data);
        }
    });
  });

  $('#btnAddFiles2').on('click',function(){
    $('#modalNoResultados').modal('hide');
    var id = $('#idLista_archivo').val();
    //console.log(id);
		var datos = {idLista : id};

		$.ajax({
        url:"all_files.htm",
        type: 'POST',
        data: datos,
        beforeSend: function(data){
          //alert('antes');
        },
        success: function(data){

            $('#rows2').replaceWith(data);
            //$('#modalEditarArchivos').modal('show');

        },//ERROR
        error: function(data){
          console.log(data);
        }
    });
  });

  $('#btnNewFiles').on('click',function(){
    var countSel = $('.cbAr2:checked').get().length;
    var idLista = $('#idLista_archivo').val();
    var archivos = $('.cbAr2:checked').get();
    //console.log("ID Lista: "+ idLista);
    //console.log("Celdas: "+ countSel);

    if(countSel > 0){
      for (var i = 0; i < countSel; i++) {
        var arch = archivos[i].value;
        //console.log(arch);
        var datos = {
          idLista : idLista,
          idArchivo : arch
        };

        $.ajax({
          type:"POST",
          url:"new_files.htm",
          data:datos,
          //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
          beforeSend: function(){
            showSpinner();
          },
          //ERROR
          error: function(error){
            removeSpinner();
            alertify.alert("Error en la transacción");
          },
          //SE HA COMPLETADO
          success:function(r){
            showSpinner();

          }
        });
        //return false;
      }
      alertify.success("Guardado correctamente");
      //TIEMPO DE ESPERA DEL AVISO
      setTimeout(function(){
        window.location.assign("listas.htm");
      }, 1200);
    }else{
      alertify.error("Favor de seleccionar al menos un archivo");
    }
  });


  $('#btnEditFiles').on('click',function(){
    var countSel = $('.orden').get().length;
    var idLista = $('#idLista_archivo').val();
    var orden = $('.orden').get();
    //console.log("ID Lista: "+ idLista);
    //console.log("Celdas: "+ countSel);
    //console.log(idLista);
    if(countSel > 0){
      for (var i = 0; i < countSel; i++) {
        var pos = orden[i].innerHTML;
        var idArchivo = orden[i].id;
        //console.log(pos);
        //console.log(idArchivo);
        var datos = {
          idLista : idLista,
          idArchivo : idArchivo,
          orden : pos
        };
        //console.log(datos);
        $.ajax({
          type:"POST",
          url:"order_files.htm",
          data:datos,
          //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
          beforeSend: function(){
            showSpinner();
          },
          //ERROR
          error: function(error){
            removeSpinner();
            alertify.alert("Error en la transacción");
            return false;
          },
          //SE HA COMPLETADO
          success:function(r){
            showSpinner();

          }
        });
        //return false;
      }
      alertify.success("Guardado correctamente");
      //TIEMPO DE ESPERA DEL AVISO
      setTimeout(function(){
        window.location.assign("listas.htm");
      }, 1200);
    }else{
      alertify.error("Favor de agregar al menos un archivo");
    }
  });

  $('#btnEliminar').on('click',function() {
    $('#modalBorrarArchivoLista').modal('show');
  });

  $('#btnDeleteAllFiles').on('click',function(){
    var countSel = $('.cbSelectOrden:checked').get().length;
    var idLista = $('#idLista_archivo').val();
    var archivos = $('.cbSelectOrden:checked').get();
    //console.log("ID Lista: "+ idLista);
    //console.log("Celdas: "+ countSel);
    //console.log(idLista);
    if(countSel > 0){
      for (var i = 0; i < countSel; i++) {
        var idArchivo = archivos[i].value;
        //console.log(pos);
        //console.log(idArchivo);
        var datos = {
          idLista : idLista,
          idArchivo : idArchivo
        };
        //console.log(datos);
        $.ajax({
          type:"POST",
          url:"delete_files.htm",
          data:datos,
          //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
          beforeSend: function(){
            showSpinner();
          },
          //ERROR
          error: function(error){
            removeSpinner();
            alertify.alert("Error en la transacción");
            return false;
          },
          //SE HA COMPLETADO
          success:function(r){
            showSpinner();

          }
        });
        //return false;
      }
      alertify.success("Guardado correctamente");
      //TIEMPO DE ESPERA DEL AVISO
      setTimeout(function(){
        window.location.assign("listas.htm");
      }, 1200);
    }else{
      alertify.error("Favor de agregar al menos un archivo");
    }
  });
