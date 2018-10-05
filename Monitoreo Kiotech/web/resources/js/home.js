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

  $('.ico-edit').on('click', function(){
    $('#modalEditarArchivo').modal('show');
  });

  $('.ico-del').on('click', function(){
    alert('archivo borrado');
  });

});
