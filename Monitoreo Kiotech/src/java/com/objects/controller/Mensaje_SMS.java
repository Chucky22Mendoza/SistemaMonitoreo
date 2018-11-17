/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.objects.controller;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class Mensaje_SMS {
    private String mensaje;
    private String celular;

    public Mensaje_SMS() {
    }

    public Mensaje_SMS(String mensaje, String celular) {
        this.mensaje = mensaje;
        this.celular = celular;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
