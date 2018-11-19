$(document).ready(function(){
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
});
