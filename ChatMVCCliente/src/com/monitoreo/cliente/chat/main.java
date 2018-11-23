/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.chat;

import com.monitoreo.cliente.database.Sincronizacion;
import com.monitoreo.cliente.model.objects.fn_sincronizar_kioscoModel;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        /**** ESTE ES UN EJEMPLO DE ENVIO DE DATOS DESDE CLIENTE****/
        List<fn_sincronizar_kioscoModel> lista = new Sincronizacion().get_kiosco();
        /**** AQUÍ ESTÁS OBTENIENDO LA LISTA DEL OBJETO DESPUÉS DE CONSULTAR LA BASE DE DATOS, PUEDES CLICKEAR CON CTRL+CLICK EN "get_kiosco()" Y TE LLEVA AL MÉTODO****/
        /****DESPUÉS DEBERÍA DE IR UN MÉTODO DONDE LOS ENVIE, EN ESTE CASO DEBERÍA DE SER EL BOTÓN DE SINCRONIZAR QUE YA EXISTE****/
        /****Sincronizacion.java CONTIENE TODOS MÉTODOS QUE DEBEN ENVIARSE, BUENO, NO SÉ, SI ALCANZAS AGREGA LOS QUE NO ESTÉN SEGUN LOS MODELOS****/
        /****PERO SE TIENE QUE DESAHACER LA LISTA POR OBJETO PARA PODER RECIBIRLO, ESTO ES EN EL SERVIDOR *****/
        /**** EN EL MAIN EXPLICO COMO RECIBIRLO****/
    }
    
}
