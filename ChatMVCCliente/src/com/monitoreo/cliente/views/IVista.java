/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreo.cliente.views;

import com.monitoreo.cliente.controller.ControladorCliente;

/**
 *
 */
public interface IVista {
    final String ENVIAR = "ENVIAR";
    final String Sincronizar="Sincronizar";
   // final String STATUSMantenimiento = "STATUSMantenimiento";
   // final String ModificarSTATUS = "ModificarSTATUS";
    
    public void habilitarEnviar();
    public void deshabilitarEnviar();
    public void agnadirMensajeATrasiego(String mensaje);
    public void borrarTextoAEnviar();
    public void setControlador(ControladorCliente controlador);
    public void hacerVisible();
    public void inicializar();
    public void habilitarBtnStatus();
    public String getMensajeAEnviar();
    public String getMensajeAEnviarPassword();
}
