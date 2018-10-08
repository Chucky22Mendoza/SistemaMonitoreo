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
				showSpinner();
			},
      //ERROR
			error: function(error){
				removeSpinner();
        alertify.alert("Error al iniciar sesión");
      },
      //SE HA COMPLETADO
      success:function(r){
        showSpinner();
        window.location.assign("home.htm");
      }
    });
    return false;
  });
});
