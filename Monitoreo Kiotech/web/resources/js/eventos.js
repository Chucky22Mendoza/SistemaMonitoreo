$(document).ready(function(){
  $('#cbGenKio').prop('checked',false);
  $('.cbSelecKiosco').prop('checked',false);
  
  $('#cbGenKio').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbSelecKiosco').prop('checked',true);
    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
    }
  });
  $('#btnMinFolios').on('click', function(){
    var minFolios = $('#folios').val();
    var datos = {
      minFolios : minFolios
    };

    $.ajax({
      type:"POST",
      url:"min_folios.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
        alertify.success('Cargando...');
      },
      //ERROR
      error: function(error){
        alertify.error('Error en la transacción');
      },
      //SE HA COMPLETADO
      success:function(r){

        if(r == 1){
          alertify.success('La configuración se ha guardado correctamente');
          setTimeout(function(){
            window.location.assign("eventos.htm");
          }, 1200);

        }else{
          alertify.error('Error al intentar guardar la configuración');
        }

      }
    });
    return false;
  });

  $('#btnDenominaciones').on('click', function(){
    var countSel = $('.denom').get().length;
    var denom = $('.denom').get();

    for(var i = 0; i < countSel; i++){
      var id = denom[i].id;
      var cant_min = denom[i].value;

      var datos = {
        id_denominacion : id,
        cantidad_min : cant_min
      };
      //console.log(datos);
      $.ajax({
        type:"POST",
        url:"denom_cant_min.htm",
        data:datos,
        //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
        beforeSend: function(){
          alertify.success('Cargando...');
        },
        //ERROR
        error: function(error){
          alertify.error('Error en la transacción');
        },
        //SE HA COMPLETADO
        success:function(r){
          alertify.success('La configuración se ha guardado correctamente');
        }
      });

    }

    setTimeout(function(){
      window.location.assign("eventos.htm");
    }, 1200);

  });

  $('#btnContenedores').on('click', function(){
    var countSel = $('.conte').get().length;
    var conte = $('.conte').get();

    for(var i = 0; i < countSel; i++){
      var id = conte[i].id;
      var cant_max = conte[i].value;

      var datos = {
        id_contenedor : id,
        cantidad_max : cant_max
      };
      //console.log(datos);
      $.ajax({
        type:"POST",
        url:"contenedores.htm",
        data:datos,
        //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
        beforeSend: function(){
          alertify.success('Cargando...');
        },
        //ERROR
        error: function(error){
          alertify.error('Error en la transacción');
        },
        //SE HA COMPLETADO
        success:function(r){
          alertify.success('La configuración se ha guardado correctamente');
        }
      });

    }

    setTimeout(function(){
      window.location.assign("eventos.htm");
    }, 1200);

  });

  $('#btnCorteCaja').on('click', function(){
    var countSel = $('.cbSelecKiosco:checked').get().length;
    var kioscos = $('.cbSelecKiosco:checked').get();
    var hr_ini = $('#horaInicial').val();
    var hr_fin = $('#horaFin').val();
    var lngIni = hr_ini.length;
    var lngFin = hr_fin.length;

    var countCk = 0;

    var domingo = $('#D').is(':checked');
		if(domingo){countCk++;}

		var lunes = $('#L').is(':checked');
		if(lunes){countCk++;}

		var martes = $('#Ma').is(':checked');
		if(martes){countCk++;}

		var miercoles = $('#Mi').is(':checked');
		if(miercoles){countCk++;}

		var jueves = $('#J').is(':checked');
		if(jueves){countCk++;}

		var viernes = $('#V').is(':checked');
		if(viernes){countCk++;}

		var sabado = $('#S').is(':checked');
		if(sabado){countCk++;}

    //console.log(lunes);

    if(countCk > 0 && lngIni > 0 && lngFin > 0){
      for(var i = 0; i < countSel; i++){
        var id = kioscos[i].id;

        var datos = {
          hora_inicio : hr_ini,
          hora_final : hr_fin,
          domingo : domingo,
          lunes : lunes,
          martes : martes,
          miercoles : miercoles,
          jueves : jueves,
          viernes : viernes,
          sabado : sabado,
          id_kiosco : id
        };
        //console.log(datos);
        $.ajax({
          type:"POST",
          url:"horario_corte.htm",
          data:datos,
          //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
          beforeSend: function(){
            alertify.success('Cargando...');
          },
          //ERROR
          error: function(error){
            alertify.error('Error en la transacción');
          },
          //SE HA COMPLETADO
          success:function(r){
            alertify.success('La configuración se ha guardado correctamente');
          }
        });

      }

      setTimeout(function(){
        window.location.assign("eventos.htm");
      }, 1200);
    }else{
      alertify.error('Favor de llenar los campos correspondientes');
    }


  });
});
