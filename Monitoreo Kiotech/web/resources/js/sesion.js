$(document).ready(function(){
  //PROCESO CON AJAX PARA EL INICIO DE SESIÓN
  $('#btnLogIn').click(function(){
    //VARIABLE DEL FORMULARIO
    var datos = $('#formLogIn').serialize();

    //PARAMETROS DENTRO DEL FORMULARIO
    var user = $('#user').val();
    var pass = $('#pass').val();

    //ABRIMOS AJAX
    $.ajax({
      type:"POST",
      url:"sesion.htm",
      data:datos,
      //MOSTRAMOS SPINNER SI ES TARDADO EL PROCESO
      beforeSend: function(){
				alertify.success('Cargando...');
			},
      //ERROR
			error: function(error){
        alertify.error("Error al iniciar sesión");
      },
      //SE HA COMPLETADO
      success:function(r){
        alertify.success('Inicio de sesión correcto');
        setTimeout(function(){
          window.location.assign("home.htm");
        }, 1200);
      }
    });
    return false;
  });
});
