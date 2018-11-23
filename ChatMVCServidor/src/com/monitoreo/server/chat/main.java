/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.server.chat;

import com.monitoreo.server.model.objects.fn_sincronizar_kioscoModel;
import com.monitoreo.server.rest.set.Web_Service;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /******DECLARACIÓN DE WEB SERVICE*****/
        Web_Service ws = new Web_Service();
        List<fn_sincronizar_kioscoModel> lista_kiosco = new ArrayList<>(); 
        //lista_kiosco = lista;
        /***LA VARIABLE "lista" ES LA QUE DEBERÍA DE RECIBIR EL SERVIDOR QUE SE MANDÓ EN EL OTRO MAIN QUE COMO PUEDES VER EN EL CLIENTE, SE ENVIÓ CON EL OBJETO***/
        int lng = lista_kiosco.size();
        /*****FORMA DE GUARDAR LAS VARIABLES POR OBJETOS, SE NECESITA SU LENGTH, O SIZE EN ESTE CASO, Y RECORRES EL OBJETO Y SE VA GUARDANDO Y ENVIANDO AL WS*****/
        for(int i = 0; i < lng;i++){
            fn_sincronizar_kioscoModel kio = new fn_sincronizar_kioscoModel();
            kio.setId_kiosco(lista_kiosco.get(i).getId_kiosco());
            kio.setNombre(lista_kiosco.get(i).getNombre());
            kio.setStatus_mantenimiento(lista_kiosco.get(i).isStatus_mantenimiento());
            kio.setIp(lista_kiosco.get(i).getIp());
            kio.setId_status(lista_kiosco.get(i).getId_status());
            kio.setId_agencia(lista_kiosco.get(i).getId_agencia());
            kio.setId_configuracion_envio(lista_kiosco.get(i).getId_configuracion_envio());
            Response stts = ws.fn_sincronizar_kiosco(kio.getId_status());
            String stts2 = String.valueOf(stts);
            int status = Integer.parseInt(stts2);
            if(status == 200){
                /***Una forma de dar una respuesta correcta***/
            }else{
                /***Aquí va el error***/
            }
        }
        
        /***TIENEN QUE SER TODOS LOS OBJETOS***/
        /****INTENTA DAR UNA RESPUESTA GENERAL***/
    }
    
}
