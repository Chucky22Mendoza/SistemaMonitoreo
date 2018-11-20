/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreo.cliente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.monitoreo.cliente.model.objects.ModeloCliente;
import com.monitoreo.cliente.views.IVista;

/**
 *
 *
 */
public class ControladorCliente implements ActionListener {
    IVista vista;
    ModeloCliente modelo;
    
    public ControladorCliente(IVista vista){
        this.vista = vista;
    }

    public ControladorCliente(IVista vista, ModeloCliente modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void arrancar(){
        vista.hacerVisible();
        vista.inicializar();
        vista.agnadirMensajeATrasiego("conectando con el Servidor...");
        modelo.conectarConElServidor();
        vista.agnadirMensajeATrasiego("Conectado al servidor.");
        modelo.crearFlujos();
        modelo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case IVista.ENVIAR:
                vista.agnadirMensajeATrasiego("Enviando Nombre al Servidor...");
                
                modelo.enviarMensajeNombre(vista.getMensajeAEnviar());
                modelo.enviarMensajePassword(vista.getMensajeAEnviarPassword());

                vista.agnadirMensajeATrasiego("Nombre & Password enviado, Esperando Confirmacion......");
                vista.agnadirMensajeATrasiego("..........");

                vista.borrarTextoAEnviar();
                
                break;
                
            case IVista.Sincronizar:
                    vista.agnadirMensajeATrasiego("Sincronizando datos");
                    modelo.Sincronizar();
                     vista.agnadirMensajeATrasiego("......");
                break;
        }
    }
    
    public void agnadirMensajeATrasiego(String mensaje){
        vista.agnadirMensajeATrasiego(mensaje);
    }
   
}
