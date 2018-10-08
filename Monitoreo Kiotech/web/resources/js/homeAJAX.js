/*--------------------SECCIÓN DE AJAX DE LA PÁGINA----------------*/
//AJAX PARA PROCESAR AL EDITAR UN ARCHIVO
  $('#updateArchivo').click(function(){
    //VARIABLE DEL FORMULARIO
    var datos = $('#EditFile').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var id = $('#id').val();
    var nombre = $('#nombre').val();
    var tipo = $('#tipo').val();
    var duracion = $('#duracion').val();

    //ABRIMOS AJAX
    $.ajax({
      type:"POST",
      url:"Edit_File.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        showSpinner();
      },
      error: function(error){
        //ERROR
        removeSpinner();
        alertify.alert("Error en la transacción");
      },
      success:function(r){
        //SE HA COMPLETADO
        showSpinner();
        alertify.success("Guardado correctamente");
        //TIEMPO DE ESPERA DEL AVISO
        setTimeout(function(){

          //Update tabla en lugar de refresh y cerrar modal
          window.location.assign("home.htm");
        }, 2000);
      }
    });
    return false;
  });

//AJAX PARA PROCESAR AL GUARDAR UN NUEVO ARCHIVO
  $('#nuevoArchivo').click(function(){
    //VARIABLE DEL FORMULARIO
    var datos = $('#NewFile').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var nombre = $('#nombre').val();
    var tipo = $('#tipo').val();
    var duracion = $('#duracion').val();

    //ABRIMOS AJAX
    $.ajax({
      type:"POST",
      url:"New_File.htm",
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
          window.location.assign("home.htm");
        }, 2000);
      }
    });
    return false;
  });

//AJAX PARA PROCESAR EL BORRADO DE UN ARCHIVO
  $('#borrarArchivo').click(function(){
    //VARIABLE DEL FORMULARIO
    var datos = $('#DelFile').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var id = $('#id').val();
    id = parseInt(id);

    //ABRIMOS AJAX
    $.ajax({
      type:"POST",
      url:"Delete_File.htm",
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
          window.location.assign("home.htm");
        }, 2000);
      }
    });
    return false;
  });
