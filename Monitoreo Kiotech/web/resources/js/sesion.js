$(document).ready(function(){
  $('#btnLogIn').click(function(){
    var datos = $('#formLogIn').serialize();
    var user = $('#user').val();
    var pass = $('#pass').val();
    $.ajax({
      type:"POST",
      url:"index.htm",
      data:datos,
      beforeSend: function(){
				showSpinner();
			},
			error: function(error){
				removeSpinner();
        alertify.alert("Error: "+ error);
      },
      success:function(r){
        removeSpinner();
        //showSpinner();
        if(pass.length > 0 && user.length > 0){
          if(r==1){
            window.location.assign("index.php");
          }else{
            alertify.alert("Error, usuario o contraseña incorrecta");
            return false;
          }
        }else{
          alertify.alert("Error, favor de ingresar los campos correspondientes");
          return false;
        }

      }
    });
    return false;
  });
});
