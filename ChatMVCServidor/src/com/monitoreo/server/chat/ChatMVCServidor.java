/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreo.server.chat;

import com.monitoreo.server.controller.ControladorServidor;
import com.monitoreo.server.model.database.ModeloServidor;
import com.monitoreo.server.views.IVista;
import com.monitoreo.server.views.VistaJFrame;

/**
 *
 *
 */
public class ChatMVCServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IVista vista = new VistaJFrame();
       ModeloServidor modelo = new ModeloServidor();
        
        ControladorServidor controlador = new ControladorServidor(vista, modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
    }
    
}
