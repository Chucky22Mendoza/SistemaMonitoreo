
function removeSpinner() {
    // eliminamos el div que bloquea pantalla
    $("#spinnerLoad").remove();

}

function showSpinner(mensaje) {
    //por si las dudas buscamos remover un spiner existente
    removeSpinner();

    //si no enviamos mensaje se pondra este por defecto
    if (mensaje === undefined)
    	mensaje = "Procesando la información<br>Espere por favor";

    //centrar el html del spinner
    height = 20;//El div del titulo, para que se vea mas arriba (H)
    var ancho = 0;
    var alto = 0;

    //obtenemos el ancho y alto de la ventana del navegador
    if (window.innerWidth == undefined)
    	ancho = window.screen.width;
    else
    	ancho = window.innerWidth;

    if (window.innerHeight == undefined)
    	alto = window.screen.height;
    else
    	alto = window.innerHeight;

    //operación necesaria para centrar el div que muestra el mensaje
    var heightdivsito = alto/3 - parseInt(height)/2;//Se utiliza en el margen superior, para centrar

    imgCentro = '<div style="text-align:center;height:px;'+ alto +'px;">'+
	    			'<div  style="color:#000;margin-top: '+ heightdivsito +'px; font-size:20px;font-weight:bold">'+ mensaje +
	    			'</div>'+
	    			'<div class="spinner">'+
					  '<div class="bounce1"></div>'+
					  '<div class="bounce2"></div>'+
					  '<div class="bounce3"></div>'+
					'</div>'+
				'</div>'




        //creamos el div grande que bloquea
        div = document.createElement("div");
        div.id = "spinnerLoad"
        div.style.width = ancho + "px";
        div.style.height = alto + "px";
        $("body").append(div);

        //creamos un input text para que el foco se plasme en este y el usuario no pueda escribir en nada de atras
        input = document.createElement("input");
        input.id = "focusInput";
        input.type = "text"

        //asignamos el div que bloquea
        $("#spinnerLoad").append(input);

        //asignamos el foco y ocultamos el input text
        $("#focusInput").focus();
        $("#focusInput").hide();

        //centramos el div del texto
        $("#spinnerLoad").html(imgCentro);

}
