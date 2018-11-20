/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.chat;

import com.monitoreo.cliente.model.objects.fn_sincronizar_kioscoModel;
import com.cliente.rest.set.Web_Service;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fn_sincronizar_kioscoModel kio = new fn_sincronizar_kioscoModel(10,"kiosco 10",false,"127.0.0.26",1,2,1);
        
        Web_Service ws = new Web_Service();
        
        
        
        System.err.println(ws.fn_sincronizar_kiosco(kio).getStatus());
    }
    
}
