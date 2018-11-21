/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreo.cliente.chat;

import com.monitoreo.cliente.controller.ControladorCliente;
import com.monitoreo.cliente.model.objects.ModeloCliente;
import com.monitoreo.cliente.views.IVista;
import com.monitoreo.cliente.views.BackFrame;

/**
 *
 *
 */
public class ChatMVCServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IVista vista = new BackFrame();
        ModeloCliente modelo = new ModeloCliente();
        
        ControladorCliente controlador = new ControladorCliente(vista, modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
    }
    
}
