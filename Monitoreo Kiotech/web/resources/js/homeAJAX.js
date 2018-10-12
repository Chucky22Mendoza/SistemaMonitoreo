/*--------------------SECCIÓN DE AJAX DE LA PÁGINA----------------*/
//AJAX PARA PROCESAR AL EDITAR UN ARCHIVO
  $('#updateArchivo').click(function(){
    //VARIABLE DEL FORMULARIO
    var datos = $('#EditFile').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var id = $('#id').val();
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

  var form = $("#NewFile");
  var btnEnviar = $("#nuevoArchivo");
  var textoSubir = btnEnviar.text();
  var textSubiendo = '<i class="fa fa-spinner fa-spin fa-3x fa-fw></i>"';
  form.bind("submit",function(e){
    var file = document.getElementById('file').files[0];

    var name = file.name;
    var type = file.type;
    console.log(name);
    var duration = $('#duracion').val();

    var datos = new FormData;

    datos.append("file",file);
    datos.append("nombre",name);
    datos.append("tipo",type);
    datos.append("duracion",duration);

    /*for (var value of datos.values()) {
      console.log(value);
    }*/

    $.ajax({
      url:"New_File.htm",
      type: 'POST',
      data: datos,
      cache: false,
      contentType: false,
      processData: false,
      beforeSend: function(data){
        showSpinner();
      },
      success: function(data){
        removeSpinner();
        $("#modalNuevoArchivo").modal('hide');
        alertify.success("Guardado correctamente");
        //console.log(data);
      },//ERROR
      error: function(data){
        removeSpinner();
        alertify.alert("Error en la transacción: Asegurarse de que el archivo no esté registrado con anterioridad ");
      }

    });
    //e.preventDefault();


    //PARAMETROS DENTRO DEL FORMULARIO
    //var file = document.getElementById('file');
    //file.addEventListener("loadeddata",function(ev){
      //var duracion = v.duration;
    //},true);

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
            window.location.assign("home.htm");
          }, 2000);

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
            window.location.assign("home.htm");
          }, 2000);
        }
      });
      return false;
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
            window.location.assign("home.htm");
          }, 2000);
        }
      });
      return false;
    });
