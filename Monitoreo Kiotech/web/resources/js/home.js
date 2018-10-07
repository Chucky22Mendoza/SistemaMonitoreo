
$(document).ready(function(){
  $('#cbGen').on('change', function() {
    var cb = $(this).is(':checked');

    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbSelec').prop('checked',true);
    } else {
        // Hacer algo si el checkbox ha sido deseleccionado
    }
  });

});

$('.ico-edit').on('click', function(){
  $('#titleName').remove();
  $('#bodyEdit').remove();
  //var name = $(this).attr('name');
  var id = $(this).attr('id');
  id = parseInt(id);
  //Obtener valores del row
  var valor = $(this).attr('value');
  valor = valor.toString();
  var str = valor.split("-");
  var nombre = str[0];
  var tipo = str[1];
  var duracion = str[2];
  duracion = parseInt(duracion);

  $('#modalEditarArchivo').modal('show');
  $('#titleModal').append('<h5 class="modal-title" id="titleName">Editar '+ nombre +'</h5> ');
  $('#modal-body').append('<div id="bodyEdit">'
     +'<input type="hidden" id="id" name="id" value="'+id+'" />'
     + '<div class="col-sm-12 row d-flex justify-content-center align-items-center mt-3">'
          +'<label for="nombre" class="col-sm-2 form-control-label mr-2">Nombre:</label>'
          +'<input class="form-control col-sm-8" id="nombre" placeholder="Cambiar nombre del archivo" type="text" name="nombre" required="required">'
       +'</div>'
       + '<div class="col-sm-12 row d-flex justify-content-center align-items-center mt-3">'
          +'<label for="tipo" class="col-sm-2 form-control-label">Tipo:</label>'
          +'<input class="form-control col-sm-8" id="tipo" placeholder="Cambiar tipo de archivo" type="text" name="tipo" required="required">'
       +'</div>'
       + '<div class="col-sm-12 row d-flex justify-content-start align-items-center mt-3 mb-2">'
          +'<label for="duracion" class="col-sm-3 form-control-label">Duración:</label>'
          +'<input class="form-control col-sm-4" id="duracion" placeholder="Segundos" type="number" name="duracion" required="required">'
       +'</div>'
  + '</div>');

  $('#nombre').val(nombre);
  $('#tipo').val(tipo);
  $('#duracion').val(duracion);

});

$('.ico-del').on('click', function(){
  alert('archivo borrado');
});
