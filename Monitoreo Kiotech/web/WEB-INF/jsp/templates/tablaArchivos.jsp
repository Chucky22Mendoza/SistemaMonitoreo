<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tbody id="rows">
  <c:set var = "posicion" value = "${rows}"/>
  <c:set var = "contador" value = "${1}"/>

  <c:forEach items="${lista}" var="dato">
    <tr style="cursor: pointer" class="takeRow" id="${dato.idArchivo}">
        <td class="text-center"><input value="${dato.idArchivo}" type="checkbox" class="mt-1 cbSelectOrden" name="cbSelectOrden" style="cursor:pointer;"></td>
        <td class="text-center orden" id="${dato.idArchivo}" name="${contador}">${contador}</td>
        <td class="text-center">${dato.nombre}</td>
        <td class="text-center">${dato.tipo}</td>
        <td class="text-center">${dato.duracion}</td>
        <td class="text-center">
          <a id="${dato.idArchivo}"  class="ico-delListArch">
            <i class="fas fa-trash-alt icono"></i>
          </a>
        </td>
        <c:set var = "contador" value = "${contador + 1}"/>

    </tr>
  </c:forEach>

</tbody>

<script>

$('#cbGenOrden').prop('checked',false);
$('.cbSelectOrden').prop('checked',false);
$('#btnEliminar').hide();

$('.takeRow').on('click',function(){
      if($(this).hasClass('activado')){
          $(this).removeClass('activado');
      }else{
          $('.takeRow').removeClass('activado');
          $(this).addClass('activado');
      }
  orden = $(this).children('.orden').attr("name");
  orden = parseInt(orden);

  });

$('#up').click(function(){
  if(orden != 0){
      var anterior = $('.activado').prev();
      var actual = $('.activado');
    //obtener orden
    var ordenAnt = anterior.children('.orden').attr("name");
    var ordenAct = actual.children('.orden').attr("name");

    //no mover el orden
    anterior.children('.orden').html(ordenAct);
    actual.children('.orden').html(ordenAnt);

    //cambiar el orden
    anterior.children('.orden').attr("name",ordenAct);
    actual.children('.orden').attr("name",ordenAnt);

      $(anterior).insertAfter(actual);
    }else{
    alert('seleccione una fila');
  }

});

$('#down').click(function(){
  if(orden != 0){
      var siguiente = $('.activado').next();
      var actual = $('.activado');
    //obtener orden
    var ordenSig = siguiente.children('.orden').attr("name");
    var ordenAct = actual.children('.orden').attr("name");
    //console.log(ordenAct + " - " + ordenSig);

    siguiente.children('.orden').html(ordenAct);
    actual.children('.orden').html(ordenSig);

    siguiente.children('.orden').attr("name",ordenAct);
    actual.children('.orden').attr("name",ordenSig);

      $(siguiente).insertBefore(actual);

  }else{
    alert('seleccione una fila');
  }
});

  $('#cbGenOrden').on('change', function() {
    var cb = $(this).is(':checked');
    if(cb) {
        // Hacer algo si el checkbox ha sido seleccionado
        $('.cbSelectOrden').prop('checked',true);
        $('#btnEliminar').show();
    } else {
        // Hacer algo si el checkbox no ha sido deseleccionado
    }
  });
  $('.cbSelectOrden').on('change', function() {
    var countSelects = $('.cbSelectOrden:checked').get().length;
    if(countSelects > 1) {
        $('#btnEliminar').show();
    } else {
        $('#btnEliminar').hide();
    }
  });

  $('.ico-delListArch').on('click',function(){
    var idLista = $('#idLista_archivo').val();
    var idArchivo = $(this).attr('id');

    alertify.confirm("¿Desea eliminar el archivo seleccionado?",
    function(){
      borrarArchivo(idLista,idArchivo);
    },
    function(){

      alertify.error('Cancel');

    });



  });

  function borrarArchivo(lista,archivo){

      var datos = {
        idLista : lista,
        idArchivo : archivo
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

        },
        //SE HA COMPLETADO
        success:function(r){
          showSpinner();
          alertify.success("Guardado correctamente");
          //TIEMPO DE ESPERA DEL AVISO
          setTimeout(function(){
            window.location.assign("listas.htm");
          }, 1200);
        }
      });
      return false;
  }
</script>
